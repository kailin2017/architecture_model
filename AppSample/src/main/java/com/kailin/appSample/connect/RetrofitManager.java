package com.kailin.appSample.connect;

import android.content.Context;

import com.google.gson.Gson;
import com.kailin.appSample.MyApplication;
import com.kailin.appSample.R;
import com.kailin.appSample.util.GsonUtil;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitManager {

    private static volatile RetrofitManager retrofitManager;

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null)
                    retrofitManager = new RetrofitManager();
            }
        }
        return retrofitManager;
    }

    private Retrofit retrofit;

    public RetrofitManager() {
        createRetrofit();
    }

    public Retrofit createRetrofit() {
        OkHttpClient okHttpClient = createOkHttpClient();

        Gson gson = GsonUtil.getInstance().getGson();

        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://ptx.transportdata.tw/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
//                .addInterceptor(new MyInterceptor())
                .cookieJar(new MyCookieJar())
                .connectTimeout(20, TimeUnit.SECONDS)
                .hostnameVerifier((s, sslSession) -> true)
//                .socketFactory(initSocketFactory())
                ;

        return builder.build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private SocketFactory initSocketFactory() {
        try {
//            InputStream inputStream = MyApplication.getInstance().getResources().openRawResource(R.raw.ptx);
//            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//            Certificate certificate = certificateFactory.generateCertificate(inputStream);
//
//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            keyStore.load(inputStream, "SocketFactory".toCharArray());
//            keyStore.setCertificateEntry("certificate", certificate);
//
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustManagerFactory.init(keyStore);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, getTrustManager(),null);
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private TrustManager[] getTrustManager() {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };
        return trustAllCerts;
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
