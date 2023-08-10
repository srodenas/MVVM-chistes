package com.pmdm.virgen.examplemvvm.data.data_network.service

import com.pmdm.virgen.examplemvvm.data.model.model_network.ResponseJokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

//Contrato que tenemos que realizar con quien nos proporciona el servicio.
interface ApiService {

    /*
    Devuelve un objeto con todos los chistes que necesitamos. Utilizaremos corrutinas.
    La respuesta será un objeto Único que llamaremos ResponseJokes, con una lista de Objetos. Lo veremos.
     */
    @GET
    suspend fun getJokes(@Url url:String): Response <ResponseJokes>
}