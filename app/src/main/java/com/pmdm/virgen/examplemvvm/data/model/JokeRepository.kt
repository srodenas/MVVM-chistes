package com.pmdm.virgen.examplemvvm.data.model

/*
Clase estática. Será nuestro repositorio de dataClass almacenadas en memoria.
 */
class JokeRepository {

    companion object{
        var jokes : List<Joke> = emptyList()
    }
}