package com.pmdm.virgen.examplemvvm.data.model

import com.google.gson.annotations.SerializedName


/*
No presenta ningúna acción.
No modificaremos los objetos, sólo representan información.
Serializaremos la clase para retrofit
 */



data class Joke(
    @SerializedName ("joke") val joke: String,
    @SerializedName("title") val title: String

    )
