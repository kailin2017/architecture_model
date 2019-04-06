package com.kailin.appSample.connect;

import okhttp3.Interceptor;

public enum RetrofitService {

    PTX_L1(MyInterceptor.getInstance("ddf6503c26f84c178e0910cad2cf87a9", "yZHThZrgPlGleR-h7JPbhhZz0js")),
    PTX_L2(MyInterceptor.getInstance("f1c761beb431492bb36d86d5b2774942", "YrCbKQMdkTYcFkeodI_CvvCSR9I")),
    ;

    private final Interceptor interceptor;

    RetrofitService(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    public Interceptor getInterceptor() {
        return interceptor;
    }
}
