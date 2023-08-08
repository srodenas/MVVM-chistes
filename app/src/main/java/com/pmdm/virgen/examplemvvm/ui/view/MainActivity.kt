package com.pmdm.virgen.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.pmdm.virgen.examplemvvm.databinding.ActivityMainBinding
import com.pmdm.virgen.examplemvvm.ui.modelview.JokeViewModel

//https://developer.android.com/topic/libraries/architecture/viewmodel?hl=es-419

/*
Ejemplo sencillo de MVVM mediante chistes cortos.
Emularemos cada chiste mediante un Tag y el mismo chiste.
1.- Crearemos la vista (Diseño del layout main-activity. Pondremos un id al constrain.
2.- Crearemos el modelo (modelo Chiste y su provider de chistes que emulará a una BBDD.
3.- Crearemos el ViewModel. Una clase que herede de ViewModel() con un atributo que sea MutableLiveData<Modelo>.
MutableLiveData es un tipo de datos de tipo LiveData, que permitirá al Activity suscribirse a un modelo de datos. LiveData
es un observador, que en el momento que vea un cambio, notificará al Activity. Tenemos que
meterlo en un MutableLiveData, porque el modelo JokeModel irá cambiando. Éste
hará que notifique al Actitivy cuando haya algún cambio en el modelo. Una función llamada ramdomJoke, que hará que el
modelo JokeData vaya cambiando, desde un
evento producido en la View (Activity), accediendo de manerea aleatoria a un nuevo chiste por medio del provider.
Esta función, hará un cambio en el modelo y al acceder
a postValue(), estamos notificando de manera implícita y provocando un cambio en el activity que éste se enterará.
4.- Necesitamos conectar nuestro ViewModel al Activity. Desde la View (MainActivity, creamos un atributo de la ViewModel y delagamos a viewModels().
viewModels, tendrá toda la lógica para conectar con el activity. Dependencia añadida. Lo llamaremos jokeViewModel.
5.- Como nuestro jokeViewModel tiene un atributo de tipo jokeModel que es el liveData de tipo Joke, tiene un método llamado observe que acepta como
 argumento el mismo this del activity y una función lambda para que al producirse
un cambio en el modelo, éste se entere y ejecute la lógica necesaria. Recibirá el nuevo joke que hará que setear en la vista.
6.- Nos falta sólo producir el evento desde la iu. Para ello generamos un evento onClick desde nuestro @id del constrain y llamaremos al método randomJoke
para que obliguemos a producir un cambio en el modelo. Éste generará un nuevo modelo y al notificar al liveData mediante el método postValue, automáticamente
el observer informará al Activity que está suscrito a dicho ViewModel. Punto 5.
 */

class MainActivity : AppCompatActivity() {
    private val jokeViewModel : JokeViewModel by viewModels() //Asignamos el ViewModel al Activity y lo delegamos a viewModels para que se encargue de ciertas acciones.
    private lateinit var binding : ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserverChangeJoke()  //iniciamos el observador sobre cualquier cambio del modelo.
        onClickChangeJoke()  //inicializamos el listener a la pantalla.

        /*
        Para google analytics.
         */
        // Obtain the FirebaseAnalytics instance.
        firebaseAnalytics = Firebase.analytics
        registerLogsForAnalytics()
    }




    /*
        Inicializamos el observador del ViewModel frente a cualquier cambio.
        En el momento que desde el ViewModel se ejecute el postValue, se ejecutará la acción
        que le sigue al this.
     */
    private fun initObserverChangeJoke(){
        jokeViewModel.jokeModel.observe(this,  //observamos este objeto con esta acción a realizar.
            { newJoke->
                //newJoke es el nuevo Joke aleaorio. Debemos setearlo.
                binding.titleJoke.text= newJoke.title
                binding.descriptionJoke.text = newJoke.joke
            }
        )
    }



    /*
    Método que desde la IU, informará de un cambio mediante un evento.
    Se notifica al ViewModel y lanzando su acción de cambio.
     */
    private fun onClickChangeJoke(){
        binding.clyActiMain.setOnClickListener{
            jokeViewModel.changeJokeForViewModel() //llamamos al ViewModel con su función que cambiará el modelo.
        }
    }



    private fun registerLogsForAnalytics() {

        val bundle = Bundle().apply {
            this.putString("message", "Hemos integrado cpm Firebase")
            this.putString("email", "srodher115@g.educaand.es")
        }
        firebaseAnalytics.logEvent("Inicializamos", bundle)


    }


}