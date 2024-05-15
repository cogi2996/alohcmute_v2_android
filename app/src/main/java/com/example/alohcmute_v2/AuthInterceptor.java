package com.example.alohcmute_v2;

import androidx.annotation.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    private String token = "eyJhbGciOiJIUzI1NiJ9.eyJmdWxsTmFtZSI6IsSQ4bq3bmcgQ8O0bmcgVHXhuqVuIiwidXNlcklkIjoxNSwic3ViIjoidGVzdFVzZXIxMjNAZ21haWwuY29tIiwiaWF0IjoxNzE1MzIxMjQzLCJleHAiOjE3MTU0MDc2NDN9.Px26q675zav67SogrHGGSg9aS656U1LsqT-Tqju6lvw";

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .build();
        return chain.proceed(newRequest);
    }
}

