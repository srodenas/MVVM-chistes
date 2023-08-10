package com.pmdm.virgen.examplemvvm.data.model.model_network

import com.google.gson.annotations.SerializedName
import com.pmdm.virgen.examplemvvm.data.model.Joke

/*
En firebase, me he encargado de tener un único objeto con el nombre que se indica abajo
 del tipo
     {
        "-NbAwTV4RJXgMjQK01JZ" : [
                                    {},
                                    {},
                                    {}, ... , {}
                                 ]
     }

 No vamos a modificar en ningún momento los datos del objeto.
 */
class ResponseJokes (
    @SerializedName ("-NbAwTV4RJXgMjQK01JZ") var listJoke : List<Joke>
    ){
}