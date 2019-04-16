package com.example.churrascometro

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //fica esperando um click no botão biniciar
        biniciar.setOnClickListener {
            var intent = Intent(this, calcular_pessoas::class.java)

            startActivity(intent)

        }


    }
}
