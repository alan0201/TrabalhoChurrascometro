package com.example.churrascometro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_resultado.*
import android.support.v4.app.NotificationCompat.getExtras
import android.content.Intent
import kotlinx.android.synthetic.main.activity_calcular_pessoas.*


class resultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)


        //recupera os valores recebidos da outra activity;
        val dados : Bundle? = intent.extras



        val ho = dados!!.getInt("ho")
        val mul = dados.getInt("mul")
        val cri = dados.getInt("cri")




        //chama a função de calular
        calcular(ho, mul, cri)

        //fica esperando um click no botão voltar fecha a tela atual e volta para a anterior;
        bVoltar.setOnClickListener {
            finish()

        }


    }

    //função que calcula a quantidade de ingradientes para o churrasco;
    fun calcular(ho:Int, mul:Int, cri:Int){

        var totalPicanha = 0.0
        var totalmaminha = 0.0
        var totallinguica = 0.0
        var totalfrango = 0.0

        var totalcarnes:Double
        var tarroz =0.0
        var tbatata = 0.0
        var tfarofa = 0.0
        var tpao = 0.0

        var totalAcompanhamento:Double

        var ttotal = 0.0



        //verifica se os campos receberam zero ou não
        if (ho != 0 || mul != 0 || cri != 0){

            totalPicanha = (ho * 240.0)+(mul* 180)+(cri * 120)
            totalmaminha = (ho * 80.0)+(mul * 60)+(cri * 40)
            totallinguica = (ho * 40.0)+(mul * 30)+(cri * 20)
            totalfrango = (ho * 40.0)+(mul * 30)+(cri * 20)

            totalcarnes = totalPicanha+totalfrango+totallinguica+totalmaminha

            tarroz = (ho * 100.0)+(mul* 80)
            tbatata = (ho * 200.0)+(mul*150)+(cri*100)
            tfarofa = (ho * 100.0)+(mul*80)
            tpao = (ho * 1.50)+(mul * 1.50)

            totalAcompanhamento = tarroz+tbatata+tfarofa

            ttotal = (totalAcompanhamento + totalcarnes)/1000



        }else{

        }


        //converte os valores que passaram de 1000g para KG;
        if(totalPicanha >= 1000 ){
            totalPicanha = totalPicanha/1000
            tvpicanha.setText(totalPicanha.toString()+"KG")
        }else{
            tvpicanha.setText(totalPicanha.toInt().toString()+"g")
        }

        if(totalmaminha >= 1000) {
            totalmaminha = totalmaminha/1000
            tvmaminha.setText(totalmaminha.toString()+"KG")
        }else{
            tvmaminha.setText(totalmaminha.toInt().toString()+"g")
        }

        if(totallinguica >= 1000){
            totallinguica = totallinguica/1000
            tvlinguica.setText(totallinguica.toString()+"KG")
        }else{
            tvlinguica.setText(totallinguica.toInt().toString()+"g")
        }

        if(totalfrango >= 1000){
            totalfrango = totalfrango/1000
            tvfrango.setText(totalfrango.toString()+"KG")
        }else{
            tvfrango.setText(totalfrango.toInt().toString()+"g")
        }

        if(tarroz >= 1000){
            tarroz = tarroz/1000
            tvarroz.setText(tarroz.toString()+"KG")
        }else{
            tvarroz.setText(tarroz.toInt().toString()+"g")
        }

        if(tbatata >= 1000){
            tbatata = tbatata/1000
            tvbatata.setText(tbatata.toString()+"KG")
        }else{
            tvbatata.setText(tbatata.toInt().toString()+"g")
        }

        if(tfarofa >= 1000){
            tfarofa = tfarofa/1000
            tvfarofa.setText(tfarofa.toString()+"KG")
        }else{
            tvfarofa.setText(tfarofa.toInt().toString()+"g")
        }



        //seta o valor no campo
        tvpaes.setText(tpao.toInt().toString()+"UN")



        //seta o valor no campo
        tvtotal.setText(ttotal.toString()+" KG")




    }



}
