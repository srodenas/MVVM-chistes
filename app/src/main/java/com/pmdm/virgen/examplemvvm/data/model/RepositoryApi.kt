package com.pmdm.virgen.examplemvvm.data.model

import kotlin.random.Random



class RepositoryApi (var listJoke : List<Joke>){

    fun randomJoke() : Joke {
        val r = Random.nextInt(0, listJoke.size)  //o (0..NUM).random()
        return listJoke.get(r)  //ó listJoke[r]
    }
}