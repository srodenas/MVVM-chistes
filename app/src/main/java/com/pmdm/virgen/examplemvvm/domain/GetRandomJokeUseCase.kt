package com.pmdm.virgen.examplemvvm.domain

import com.pmdm.virgen.examplemvvm.data.model.Joke
import com.pmdm.virgen.examplemvvm.data.model.JokeRepository

class GetRandomJokeUseCase {

    operator fun invoke(): Joke {
        val r = (0..JokeRepository.jokes.size -1).random()  //devolvemos un aleatorio enre 0 y el tamaño - 1
        return JokeRepository.jokes.get(r)
    }

}