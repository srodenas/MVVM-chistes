package com.pmdm.virgen.examplemvvm.data.data_network

import android.util.Log
import com.pmdm.virgen.examplemvvm.data.model.model_network.ResponseJokes
import com.pmdm.virgen.examplemvvm.retrofit.InstanceRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

/*
Clase que se encarga de forma implícita de trabajar con Retrofit para la obtención de los datos.
 Es la forma que tenemos de recuperar los datos de internet.
 */
class JokeService {

    suspend fun getJokes() : ResponseJokes?{
        return withContext(Dispatchers.IO){
            val call : Response<ResponseJokes> = InstanceRetrofit.retrofitService.getJokes("/joke.json")
             if (!call.isSuccessful)
                showError()
            call.body()
        }
    }



    private fun showError() {
        Log.i("TAG-ERROR", "Ha habido algún problema en la llamada al servicio de retrofit.")
    }
}