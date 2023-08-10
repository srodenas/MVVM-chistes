package com.pmdm.virgen.examplemvvm.ui.modelview

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.virgen.examplemvvm.data.model.Joke

import com.pmdm.virgen.examplemvvm.domain.GetJokeUseCase
import com.pmdm.virgen.examplemvvm.domain.GetRandomJokeUseCase

import kotlinx.coroutines.launch


/*
Nuestro ViewModel, tentrá un atributo liveData del modelo. Será mutable porque tendrá cambios.
 */
class JokeViewModel : ViewModel() {
    var jokeModel = MutableLiveData<Joke>() //liveData que se encarga de notificar los cambios.
    val getJokeUseCase = GetJokeUseCase()  //Creamos nuestro primer caso de uso que nos devolverá todos los datos en memoria.
    val getRandomJokeUseCase = GetRandomJokeUseCase() //Creamos nuestro segundo caso de uso que será el aleatorio.


    //lanzamos la corrutina por primera vez.
    init {
        viewModelScope.launch {
            val result : List<Joke> ? = getJokeUseCase()//Aquí están todos los datos recuperados. Invoca a su método invoke porque esta con operator.

            if (!result.isNullOrEmpty()){
                jokeModel.postValue(result[11])  //cargamos nuestro primer chiste. El preferido.
            }
        }

    }

    /*
    Método que hace que el modelo cambie.
    Aquí tendré que invocar el servicio de Retrofit.
     */
    fun changeJokeForViewModel(){
        val newJoke = getRandomJokeUseCase()  //Al tener sólo un método con operator, no hace falta invocar a su método de manera implícita.
        jokeModel.postValue(newJoke)  //El viewModel, notificamos el cambio al activity.
    }



}