package com.pmdm.virgen.examplemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}