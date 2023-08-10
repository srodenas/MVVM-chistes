package com.pmdm.virgen.examplemvvm.data.data_network

import com.pmdm.virgen.examplemvvm.data.model.Joke
import com.pmdm.virgen.examplemvvm.data.model.JokeRepository

/*
Clase que se encarga de devolver todos los datos de Internet en memoria en forma de List.
No sabe cómo se cargan esos datos, esto lo hace el objeto api del tipo JokeService.
Si quisiéramos cargar los datos de otra forma que no fuera el de Retrofit, sólo nos preocuparíamos
de cambiar la clase JokeService()
 */
class RepositoryApi (){

    private val api = JokeService()  //Servicio que se encargará de recuperar los datos.

    /*
    Método que devuelve una List<Joke>.
     */
    suspend fun getAllJokes() : List<Joke>{
        val data = api.getJokes()  //servicio, dame todos los chistes.
        data.let {    //caso de que data tenga datos.
            JokeRepository.jokes = it!!.listJoke  //Los cargo en memoria.
        }
        return JokeRepository.jokes
    }



}