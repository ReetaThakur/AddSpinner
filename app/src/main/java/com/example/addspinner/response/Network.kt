package com.example.addspinner.response

import android.util.Base64
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Network {

    private val AUTH =
        "Basic " + Base64.encodeToString("UT8007:UT8007".toByteArray(), Base64.NO_WRAP)

    var okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .addHeader("Authorization", AUTH)
                .method(original.method, original.body)
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }).build()

    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://asapsgr01.3frameslab.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}