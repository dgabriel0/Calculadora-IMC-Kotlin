package com.unsatisfactorystudio.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class icqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icq)
        //ad
        val adView = AdView(this)

        adView.adSize = AdSize.BANNER

        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        MobileAds.initialize(this) {}

        var mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        //cod
        // spinner genero
        val generoSpinner = findViewById<Spinner>(R.id.spnIcqGenero)
        val listaGenero = arrayListOf<String>("Selecione o seu sexo","Feminino", "Masculino")
        val generoAdapter = ArrayAdapter(
                this,
                R.layout.style_spinner,
                listaGenero
        )
        generoSpinner.adapter = generoAdapter
        // spinner idade
        val idadeSpinner = findViewById<Spinner>(R.id.spnIcqIdade)
        val listaIdade = arrayListOf<String>("Selecione sua idade","De 20 a 29", "De 30 a 39", "De 40 a 49", "De 50 a 59","De 60 a 69")
        val idadeAdapter = ArrayAdapter(
                this,
                R.layout.style_spinner,
                listaIdade
        )
        idadeSpinner.adapter = idadeAdapter
        // Capturar dados do edt
        val cintura = findViewById<EditText>(R.id.edtIcqCintura)
        val quadril = findViewById<EditText>(R.id.edtIcqQuadril)
        val txvResultado = findViewById<TextView>(R.id.txvIcqResultado)

        var resultado : Float
        // botão
        val btnIcqCalcular = findViewById<Button>(R.id.btnIcqCalcular)
        btnIcqCalcular.setOnClickListener {
            hideKeyboard()
            val idade = idadeSpinner.selectedItem.toString()
            val sexo = generoSpinner.selectedItem.toString()
            val cintura1 = cintura.text.toString()
            val quadril1 = quadril.text.toString()
            if (cintura1.isEmpty()){
                cintura.error = "Preencha o campo"
                cintura.requestFocus()
            }else if (quadril1.isEmpty()){
                quadril.error = "Preencha o campo"
                quadril.requestFocus()
            }else if(idade.equals(listaIdade[0]) || sexo.equals(listaGenero[0])){
            txvResultado.text = "Preencha todos os campos"


            }else{
               val cintura2 = cintura1.toFloat()
               val quadril2 = quadril1.toFloat()
                resultado = cintura2/quadril2
                var resultado2 =  String.format("%.2f", resultado)

                // verificações do resultado

                if (resultado < 0.83 && idade == listaIdade[1] && sexo == listaGenero[2]){      //Masculino
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.83..0.88 && idade == listaIdade[1] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.89..0.94 && idade == listaIdade[1] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 0.94 && idade == listaIdade[1] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado < 0.84 && idade == listaIdade[2] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.84..0.91 && idade == listaIdade[2] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.92..0.96 && idade == listaIdade[2] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 0.96 && idade == listaIdade[2] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado < 0.88 && idade == listaIdade[3] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.88..0.95 && idade == listaIdade[3] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.96..1.00 && idade == listaIdade[3] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 1.00 && idade == listaIdade[3] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado < 0.90 && idade == listaIdade[4] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.90..0.96 && idade == listaIdade[4] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.97..1.02 && idade == listaIdade[4] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 1.02 && idade == listaIdade[4] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado < 0.91 && idade == listaIdade[5] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.91..0.98 && idade == listaIdade[5] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.99..1.03 && idade == listaIdade[5] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 1.03 && idade == listaIdade[5] && sexo == listaGenero[2]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado < 0.71 && idade == listaIdade[1] && sexo == listaGenero[1]){    // Feminino
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.71..0.77 && idade == listaIdade[1] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.78..0.82 && idade == listaIdade[1] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 0.82 && idade == listaIdade[1] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado < 0.72 && idade == listaIdade[2] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.72..0.78 && idade == listaIdade[2] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.79..0.84 && idade == listaIdade[2] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 0.84 && idade == listaIdade[2] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado < 0.73 && idade == listaIdade[3] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.73..0.79 && idade == listaIdade[3] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.80..0.87 && idade == listaIdade[3] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 0.87 && idade == listaIdade[3] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado < 0.74 && idade == listaIdade[4] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.74..0.81 && idade == listaIdade[4] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.82..0.88 && idade == listaIdade[4] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 0.88 && idade == listaIdade[4] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado < 0.76 && idade == listaIdade[5] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco baixo de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.76..0.83 && idade == listaIdade[5] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco moderado de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado in 0.84..0.90 && idade == listaIdade[5] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }else if (resultado > 0.90 && idade == listaIdade[5] && sexo == listaGenero[1]){
                    resultado2 = """Seu ICQ é: $resultado2
Você tem um risco muito alto de desenvolver 
doenças cardiovasculares.
                        """
                    txvResultado.text = resultado2
                }

            }
        }
    }
}