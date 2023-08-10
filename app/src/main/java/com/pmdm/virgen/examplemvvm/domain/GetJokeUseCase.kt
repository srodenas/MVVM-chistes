package com.pmdm.virgen.examplemvvm.domain

import com.pmdm.virgen.examplemvvm.data.model.Joke
import com.pmdm.virgen.examplemvvm.data.data_network.RepositoryApi

/*
Este fichero, representa un caso de uso de la aplicación.
El caso de uso en este caso, sería llamar a los datos del repositorio e invocar un random.
Este caso de uso, sólo debe recuperar de data, los datos
 */

class GetJokeUseCase {
    private val repository = RepositoryApi()  //objeto que contendrá todos los chistes cargados de Internet.

    suspend operator fun invoke(): List<Joke> ? = repository.getAllJokes()  //método que devolverá todos los chistes a una List.


    /*
    poniendo operator, lo que hacemos es cuando queramos invocar al método invoke(), en vez
    de hacer GetJokeUseCase().invoke(), sólo tendríamos que hacer GetJokeUseCase() y automáticamente
    se llamará a invoke()
     */
}