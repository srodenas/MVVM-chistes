package com.pmdm.virgen.examplemvvm.interface_retrofit

import com.pmdm.virgen.examplemvvm.data.model.ResponseJokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

//Contrato que tenemos que realizar con quien nos proporciona el servicio.
interface ApiService {

    //Devuelve un objeto con todos los chistes que necesitamos.
    @GET
    suspend fun getJokes(@Url url:String): Response <ResponseJokes>
}