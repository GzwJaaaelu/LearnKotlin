package com.kotlin.`in`.mooc.coroutine.common

import okhttp3.ResponseBody

const val LOGO_URL = "http://www.imooc.com/static/img/index/logo.png?t=1.1"

object HttpService {

    val service by lazy {
        val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl("http://www.imooc.com")
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()

        retrofit.create(com.kotlin.`in`.mooc.coroutine.common.Service::class.java)
    }

}

interface Service {

    @retrofit2.http.GET
    fun getLogo(@retrofit2.http.Url fileUrl: String): retrofit2.Call<ResponseBody>

}