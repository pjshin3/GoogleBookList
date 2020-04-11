package com.example.mygooglebook.di

import android.os.Build
import com.example.mygooglebook.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L
private const val BASE_URL = "https://www.googleapis.com/"

val remoteModule = module {

    //okhttp 캐시설정
    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }

    //Gson 빌드
    single { GsonBuilder().create() }

    //okhttp 클라이언트 초기화
    single { OkHttpClient.Builder().apply {
        cache(get())
        connectTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
        addInterceptor(get())
        addInterceptor(HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG){
                level = HttpLoggingInterceptor.Level.BODY
            }
        })
    }}

    //retrofit 초기화
    single { Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        client(get()) // 네트워크 계층의 OKHTTP 클라이언트를 생성해놓은 객체를 가져옴. ** RETROFIT은 OKHTTP 위에서 동작함.
        build()
    }}

    //okhttp 인터셉터 초기화
    single {
        Interceptor{ chain ->
            chain.proceed(chain.request().newBuilder().apply {
                header("Accept","application/json")
            }.build())
        }
    }

}