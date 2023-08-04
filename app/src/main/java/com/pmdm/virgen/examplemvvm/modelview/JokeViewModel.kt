package com.pmdm.virgen.examplemvvm.modelview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pmdm.virgen.examplemvvm.model.Joke
import com.pmdm.virgen.examplemvvm.model.Repository

/*
Nuestro ViewModel, tentrá un atributo liveData del modelo. Será mutable porque tendrá cambios.
 */
class JokeViewModel : ViewModel() {
    var jokeModel = MutableLiveData<Joke>() //liveData que se encarga de notificar los cambios.



    /*
    Método que hace que el modelo cambie.
     */
    fun changeJokeForViewModel(){
        val newJoke = Repository.randomJoke()  //Objetemos el nuevo Chiste.
        jokeModel.postValue(newJoke)  //El viewModel, notificamos el cambio al activity.
    }

    fun initFirstJoke(){
        jokeModel.postValue(Repository.initFirstJoke())
    }
}