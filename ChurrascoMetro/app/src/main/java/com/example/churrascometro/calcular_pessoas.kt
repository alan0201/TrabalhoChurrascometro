package com.example.churrascometro

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calcular_pessoas.*

class calcular_pessoas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_pessoas)


        //fica esperando um click no botão bcalcular;
        bcalcular.setOnClickListener {

            val intent = Intent(this, resultado::class.java)

            val dados = Bundle()


            val ho = eTHomens.text.toString()
            val mul = eTMulher.text.toString()
            val cri = eTCrianca.text.toString()


            //valida se os campos estão preenchidos ou não;
            val validade = validacampo(ho, mul, cri)

            //executa os calculos se os campos não estiverem vazios;
            if(validade == true){
                tvalerta.setText("Preencha os campos")
            }else{
                tvalerta.setText("")
                //captura os valores para enviar para outra activity;
                dados.putInt("ho", ho.toInt())
                dados.putInt("mul", mul.toInt())
                dados.putInt("cri", cri.toInt())

                intent.putExtras(dados)

                startActivity(intent)

            }



        }


    }
    //função que verifica se os campos estão vazios ou não;
    fun validacampo(ho:String, mul:String, cri:String):Boolean{

        var validade = false
        if( ho.isEmpty()){
            validade = true
        }else if( mul.isEmpty()){
             validade = true
        }else if( cri.isEmpty()){
             validade = true
        }
        return validade

    }
}
