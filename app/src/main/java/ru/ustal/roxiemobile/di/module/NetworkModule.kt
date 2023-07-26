package ru.ustal.roxiemobile.di.module

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.ustal.roxiemobile.data.remote.OAuthAuthenticator
import ru.ustal.roxiemobile.data.remote.PixelsApi
import ru.ustal.roxiemobile.data.remote.RoxiApi
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptors: ArrayList<Interceptor>
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .followRedirects(false)
        interceptors.forEach {
            clientBuilder.addInterceptor(it)
        }
        return clientBuilder
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .authenticator(OAuthAuthenticator())
            .build()
    }

    @Singleton
    @Provides
    fun provideInterceptors(): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        interceptors.add(loggingInterceptor)
        return interceptors
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    @Singleton
    fun provideRoxiApi(retrofitBuilder: Retrofit.Builder): RoxiApi {
        return retrofitBuilder
            .baseUrl("https://www.roxiemobile.ru/")
            .build()
            .create(RoxiApi::class.java)
    }

    @Provides
    @Singleton
    fun providePixelsApi(retrofitBuilder: Retrofit.Builder): PixelsApi {
        return retrofitBuilder
            .baseUrl("https://api.pexels.com/")
            .build()
            .create(PixelsApi::class.java)
    }

}