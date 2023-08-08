package com.pmdm.virgen.examplemvvm.ui.modelview

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pmdm.virgen.examplemvvm.data.model.Joke
import com.pmdm.virgen.examplemvvm.data.model.RepositoryApi
import com.pmdm.virgen.examplemvvm.data.model.ResponseJokes
import com.pmdm.virgen.examplemvvm.retrofit.InstanceRetrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

/*
Nuestro ViewModel, tentrá un atributo liveData del modelo. Será mutable porque tendrá cambios.
 */
class JokeViewModel : ViewModel() {
    var jokeModel = MutableLiveData<Joke>() //liveData que se encarga de notificar los cambios.
    lateinit var listJoke : RepositoryApi

    init {
        getJokesForApi()
    }

    /*
    Método que hace que el modelo cambie.
    Aquí tendré que invocar el servicio de Retrofit.
     */
    fun changeJokeForViewModel(){
        val newJoke = listJoke.randomJoke() //Objetemos el nuevo Chiste.
        jokeModel.postValue(newJoke)  //El viewModel, notificamos el cambio al activity.
    }


    /*
    Esta función, se encargará en segundo plano y de manera asíncrona de invocar al servico
    de Retrofit.
     */
    fun getJokesForApi(){
        CoroutineScope(Dispatchers.IO).launch {
            val call : Response<ResponseJokes> = InstanceRetrofit.retrofitService.getJokes("/joke.json")
            val data : ResponseJokes? = call.body()  //pongo ?, porque puede ser nulo.
            if (call.isSuccessful){
                val list = data?.listJoke ?: emptyList()
                listJoke = RepositoryApi(list)


            }else{
                listJoke = RepositoryApi(emptyList())
                showError()

            }
        }
    }


    private fun showError() {
        Log.i("err-api", "Error en la obtención de los objetos GET")
    }



}