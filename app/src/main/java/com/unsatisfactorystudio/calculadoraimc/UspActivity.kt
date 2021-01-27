package com.unsatisfactorystudio.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class UspActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usp)
        //ad
        val adView = AdView(this)

        adView.adSize = AdSize.BANNER

        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        MobileAds.initialize(this) {}

        var mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        //codigo
        val peso = findViewById<EditText>(R.id.edtImccPeso)
        val gordura = findViewById<EditText>(R.id.edtImccGordura)
        val altura = findViewById<EditText>(R.id.edtImccAltura)
        val txvresultado = findViewById<TextView>(R.id.txvImccResultado)
        val imccCalcular = findViewById<Button>(R.id.btnImccCalcular)
        imccCalcular.setOnClickListener {
            hideKeyboard()
            val peso1 = peso.text.toString()
            val gordura1 = gordura.text.toString()
            val altura1 = altura.text.toString()


            if (peso1.isEmpty()) {
                peso.error = "Preencha o campo"
                peso.requestFocus()
            }else if (gordura1.isEmpty()) {
                gordura.error = "Preencha o campo"
                gordura.requestFocus()
            }else if (altura1.isEmpty()) {
                altura.error = "Preencha o campo"
                altura.requestFocus()
            } else {
                val peso2 = peso1.toFloat()
                val percentual2 = gordura1.toFloat()
                val altura2 = altura1.toFloat()
                val resultado = ((3 * peso2) + (4 * percentual2)) / altura2
                var resultado2 = String.format("%.2f", resultado)

                if (resultado < 1.65 && resultado>1.35) {
                    resultado2 = """Seu IMC USP é: $resultado2
Você está abaixo do peso ideal segundo o estudo da USP
IMC USP de 1.35 a 1.65
          """.trim()

                    txvresultado.text = resultado2

                } else if (resultado in 1.65..2.0) {
                    resultado2 = """Seu IMC USP é: $resultado2
Você está com o peso ideal segundo o estudo da USP
IMC USP de 1.65 a 2
          """.trim()

                    txvresultado.text = resultado2
                } else if (resultado > 2) {
                    resultado2 = """Seu IMC USP é: $resultado2
Você está com o peso ideal segundo o estudo da USP
IMC USP de 1.65 a 2
          """.trim()

                    txvresultado.text =resultado2
                }else{ resultado2 = """Seu IMC USP é: $resultado2
                    E não se encontra na tabela, pois está abaixo de 1.35
                    logo você está abaixo do abaixo de peso,procure um médico"""

                    txvresultado.text =resultado2
                }

            }
        }
    }
}