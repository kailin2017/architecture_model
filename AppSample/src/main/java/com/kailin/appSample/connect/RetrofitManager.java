package com.kailin.appSample.connect;

import android.content.res.Resources;

import com.google.gson.Gson;
import com.kailin.appSample.MyApplication;
import com.kailin.appSample.R;
import com.kailin.appSample.util.GsonUtil;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitManager {

    private static volatile WeakHashMap<RetrofitService, RetrofitManager> weakHashMap = new WeakHashMap<>();

    public static RetrofitManager getInstance(RetrofitService service) {
        RetrofitManager retrofitManager = weakHashMap.get(service);
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                retrofitManager = weakHashMap.get(service);
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager(service.getInterceptor());
                    weakHashMap.put(service, retrofitManager);
                }
            }
        }
        return retrofitManager;
    }

    private Retrofit retrofit;

    public RetrofitManager(Interceptor interceptor) {
        createRetrofit(interceptor);
    }

    public void createRetrofit(Interceptor interceptor) {
        OkHttpClient okHttpClient = createOkHttpClient(interceptor);

        Gson gson = GsonUtil.getInstance().getGson();

        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://ptx.transportdata.tw/")
                .client(okHttpClient)
                .build();
    }

    private OkHttpClient createOkHttpClient(Interceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(20, TimeUnit.SECONDS);

        initSSLSocketFactory(builder);

        return builder.build();
    }


    private void initSSLSocketFactory(OkHttpClient.Builder builder) {
        try {
            char[] keyStorePassword = "fuckPassword".toCharArray();
            Resources resources = MyApplication.getInstance().getResources();
            InputStream inputStream = resources.openRawResource(R.raw.ptx);

            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, keyStorePassword);
            keyStore.setCertificateEntry("ptx", certificateFactory.generateCertificate(inputStream));

            inputStream.close();

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, keyStorePassword);

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
            sslContext.getSocketFactory();

            TrustManager trustManager = trustManagerFactory.getTrustManagers()[0];
            if (trustManager instanceof X509TrustManager) {
                builder.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustManager);
            } else {
                builder.sslSocketFactory(sslContext.getSocketFactory());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }

}
