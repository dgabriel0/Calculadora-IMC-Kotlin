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

class imcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        // ad
        val adView = AdView(this)

        adView.adSize = AdSize.BANNER

        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        MobileAds.initialize(this) {}
//codigo
        var mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        val peso = findViewById<EditText>(R.id.edtImcPeso)
        val altura = findViewById<EditText>(R.id.edtImcAltura)
        val butCalcular = findViewById<Button>(R.id.btnImcCalcular)
        val resultadotext = findViewById<TextView>(R.id.edtImcResultado)
        butCalcular.setOnClickListener {
            hideKeyboard()
            //passar variaveis para String, para poder fazer as verificações
            val peso1 = peso.text.toString()
            val altura1 = altura.text.toString()
            if (peso1.isEmpty()) {
              peso.error = "Preencha o campo"
                peso.requestFocus()
            }else if(altura1.isEmpty()){
                altura.error = "Preencha o campo"
                altura.requestFocus()
            }else{
                val peso2 = peso1.toFloat()
                val altura2 = altura1.toFloat()
                val resultado : Float
                resultado = peso2/((altura2/100)*(altura2/100))
                //// formatar o float para 2 casas
               var resultado2 =  String.format("%.2f", resultado)

                if (resultado in 25.00..29.99){
                    resultado2 = """Seu IMC é: $resultado2
Você está acima do peso ideal
IMC de 25 a 29.9

Implicações e riscos
Fadiga, problemas digestivos e circulatórios, má circulação nas pernas e varizes. 
          """

                    resultadotext.text =resultado2

                }else if (resultado in 30.00..34.99){
                    resultado2 = """Seu IMC é: $resultado2
Você está com obesidade tipo 1
IMC de 30 a 34.99

Implicações e riscos
Diabetes, angina de peito, enfartes, trombo flebites, srteroscleroses, embolias, alterações menstruais.
          """

                    resultadotext.text =resultado2
                }else if (resultado in 35.00..39.99) {
                    resultado2 = """Seu IMC é: $resultado2
Você está com obesidade tipo 2
IMC de 35 a 39.99

Implicações e riscos
Falta de ar, apneia, sonolência, trombose pulmonar, úlceras varicosas, cancro do cólon, uterino e mamário, refluxo esofágico, descriminação social.
          """

                    resultadotext.text =resultado2

                }else if (resultado >=40.00){
                    resultado2 = """Seu IMC é: $resultado2
Você está com obesidade tipo 3
IMC maior que 40

Implicações e riscos
PROCURE UM MEDICO COM URGÊNCIA!!
          """

                    resultadotext.text =resultado2
                }else if (resultado in 18.60..24.99){
                    resultado2 = """Seu IMC é: $resultado2
Você está com o IMC ideal, parabéns!!
IMC de 18.6 a 24.99

Implicações e riscos
Estado normal, bom nível de energia, vitalidade e boa condição física.
          """

                    resultadotext.text =resultado2

                }else if (resultado in 15.00..18.59){
                    resultado2 = """Seu IMC é: $resultado2
Você está abaixo do peso ideal
IMC de 15 a 18.59

Implicações e riscos
Transtornos digestivos, debilidade, fadiga crônica, stress, ansiedade e difusão das hormonas.
          """

                    resultadotext.text =resultado2

                }else if (resultado <15.00){
                    resultado2 = """Seu IMC é: $resultado2
Você está muito abaixo do peso ideal
IMC menor que 15

Implicações e riscos
PROCURE UM MEDICO COM URGÊNCIA!!
          """

                    resultadotext.text =resultado2

                }



            }


        }
    }
}