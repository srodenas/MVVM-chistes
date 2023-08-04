package com.pmdm.virgen.examplemvvm.model

import kotlin.random.Random


/*
- Al poner companion object, estamos haciendo que esta clase sea estática.
- Implementamos un método que nos devuelva un chiste aleatorio.
 */
class Repository {

    companion object{
        private val NUM = 12

        fun randomJoke() : Joke {
            val r = Random.nextInt(0, NUM)  //o (0..NUM).random()
            return listJoke.get(r)  //ó listJoke[r]
        }

        fun initFirstJoke() = listJoke.get(11)


        private val listJoke = listOf<Joke>(
            Joke("La honestidad y otros valores", "- Estoy leyendo un libro nuevo que se llama 'La honestidad y otros valores' \n" +
                    "- Que bueno, ¿dónde lo compraste? \n" +
                    "- Lo robé de la librería de la esquina"),

            Joke("Libros de contabilidad", "En la librería..\n" +
                    "- Hola, tiene libros de contabilidad?\n" +
                    "- Debe Haber, debe haber..."),
            Joke("Sintaxis", "- Papá, que significa sintaxis\n" +
                    "- Que tienes que coger el autobús\n" +
                    "- Gracias papá, eres genial\n" +
                    "- Uno que ha estudiao"),
            Joke("padres, ancianas, supermercados", "- Papá ¿qué es una secuela?\n" +
                    "- ¿Te acuerdas hijo de aquella anciana que estaba en la cola del supermercado que le di una buena paliza?\n" +
                    "- Si\n" +
                    "- Pues esa ya no secuela más"),
            Joke("viejas", "- A pesar de mis 92 años, todavía trabajo.\n" +
                    "- ¿Qué hace, abuela?\n" +
                    "- Cuido a una anciana."),
            Joke("La honestidad y otros valores", "- Estoy leyendo un libro nuevo que se llama \"La honestidad y otros valores\" \n" +
                    "- Que bueno, ¿dónde lo compraste? \n" +
                    "- Lo robé de la librería de la esquina" ),
            Joke("Saludable", "- Soy una persona muy saludable.\n" +
                    "- ¿Haces mucho deporte y comes sano?\n" +
                    "- No. Es que la gente me saluda por la calle y yo... pues les devuelvo el saludo."),
            Joke("El hombré que entró en mi casa", "Entra un borracho en una comisaría: \n" +
                    "- ¿Podría ver al hombre que robó ayer en mi casa? \n" +
                    "- ¿Y para qué lo quiere ver? \n" +
                    "- Para saber cómo entró sin despertar a mi mujer."),
            Joke("Envases", "Entra un borracho a una bodega y dice:\n" +
                    "- Me da 20 litros de vino?\n" +
                    "- Ha traido el envase?\n" +
                    "- Esta usted hablando con el."),
            Joke("¿Doctor?", "- Doctor, doctor, ¿qué tal ha salido la operación?\n" +
                    "- ¡Pero qué doctor ni que ocho cuartos! ¡Mire Ud. yo soy San Pedro!"),

            Joke("Dejar el fútbol", "Entre dos hombres\n" +
                    "– Mi doctor me aconsejó renunciar a jugar fútbol. \n" +
                    "– ¿Por qué, estas enfermo? \n" +
                    "– No, él me ha visto como juego."),

            Joke("No puedo dormir", "- Doctor, no puedo dormir\n" +
                    "- Si me echo del lado izquierdo se me sube el hígado y si me echo del derecho se me sube el riñón.\n" +
                    "- Pues, acuéstese boca arriba.\n" +
                    "- Entonces se me sube mi marido.")


        )

    }
}