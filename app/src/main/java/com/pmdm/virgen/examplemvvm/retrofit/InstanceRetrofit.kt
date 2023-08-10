package com.pmdm.virgen.examplemvvm.retrofit

import com.pmdm.virgen.examplemvvm.data.data_network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanceRetrofit {

    private const val BASE_URL = "https://nomadic-basis-360417-default-rtdb.europe-west1.firebasedatabase.app/"

    //De alguna forma, al llamar a retrofitService del tipo Interfaz, retrofit crea las llamadas implementadas en ApiService.
    val retrofitService : ApiService by lazy {
        getRetrofit().create(ApiService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        val ret = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return ret
    }

}