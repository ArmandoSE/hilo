package com.example.hilo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var tiempo = 0
    var hilo = true
    var etiqueta: TextView? = null
    var iniciar : Button?=null
    var pausar  : Button?=null
    var reiniciar:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etiqueta = findViewById(R.id.etiqueta)
        iniciar = findViewById(R.id.iniciar)
        pausar = findViewById(R.id.pausa)
        reiniciar = findViewById(R.id.rei)

        IniciarH()

        iniciar?.setOnClickListener {
            Iniciar()
        }
        pausar?.setOnClickListener {
            Pausa()
        }
        reiniciar?.setOnClickListener {
            Reiniciar()
        }
    }

    override fun onStart() {
        super.onStart()
        empiezaH()
    }

    override fun onPause() {
        super.onPause()
        if(hilo==true){
            hilo=false
        }
    }

    override fun onResume() {
        super.onResume()
        empiezaH()
        reiniciaH()
    }

    override fun onStop() {
        super.onStop()
        if (hilo){
            hilo = false
        }
    }

    override fun onRestart() {
        super.onRestart()
        if (hilo){
            hilo=true
        }
    }

    fun Iniciar(){
        hilo=true
    }
    fun Pausa(){
        hilo=false
    }
    fun Reiniciar(){
        tiempo=0
        hilo=false
    }
    private fun IniciarH(){
        val handler= Handler()
        handler.post(object : Runnable{
            override fun run() {

                etiqueta?.setText(""+tiempo)
                if (hilo){
                    tiempo++
                }
                handler.postDelayed(this,1000)
            }
        })
    }
    private fun empiezaH(){
        if(!hilo){
            hilo==true
        }
    }
    private fun  reiniciaH(){
        if (tiempo>0){
            etiqueta?.setText(""+tiempo)
            hilo=true

        }
    }
}

