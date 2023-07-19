package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.Locale

//tengo que implementar "TextToSpeech.OnInitListener" para que la app hable
class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    //variable global para guardar lo que se va a pedir que se hable
    private var tts: TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Esta linea llama a la vista de la app
        setContentView(R.layout.activity_main)

        //Esta linea accede al component de la vista especificnado de que tipo "TextView"
        //Despues lo guarda en una variable
        val mensaje: String = findViewById<TextView>(R.id.tvEstado).text.toString()

        //Esta linea es como un "print" pero lo hace dentro de Logcat que es en donde podemos ver todos los
        //eventos que van pasando en la app
        Log.i("El mensaje escrito es: ", mensaje)


        //inicializo el metodo
        //vasicamente el TextToSpeech es un metodo para leer y escuchar el texto
        tts = TextToSpeech(this, this)

        //esta linea llama a travez de el id al boton y manda lo leido a la funcion creada mas abajo
        findViewById<Button>(R.id.btnPlay).setOnClickListener { hablar() }


    }

    //funcion para que el celular hable
    private fun hablar() {
        //traigo el valor de la variable
        var mensaje: String = findViewById<TextView>(R.id.etMensaje).text.toString()
        //verifico que la variable mensaje que se va a escribir desde el celular sea vacia para hacer:
        if(mensaje.isEmpty()){
            //cambiar el valor de la variable texto
            findViewById<TextView>(R.id.tvEstado).text = getString(R.string.tts_cambio)
            //darle un valor al mensaje para que se reproduzca
            mensaje="Escribí algo pelotudo"
        }
        // con el !! indico que la variable no es null
        tts!!.speak(mensaje, TextToSpeech.QUEUE_FLUSH, null, "")
    }


    //termino de implementar "TextToSpeech.OnInitListener"
    override fun onInit(status: Int) {
        //verifico que el dispositivo sea capaz de hablar
        if (status == TextToSpeech.SUCCESS) {
            //sobreescribe el valor de la variable
            findViewById<TextView>(R.id.tvEstado).text = getString(R.string.tts_active)
            //configuro el idioma
            tts!!.language = Locale("ES")
        } else {
            findViewById<TextView>(R.id.tvEstado).text = getString(R.string.tts_no_active)
        }
    }

    //metodo para parar la implementcion del metodo para hablar
    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }

        super.onDestroy()
    }
}

