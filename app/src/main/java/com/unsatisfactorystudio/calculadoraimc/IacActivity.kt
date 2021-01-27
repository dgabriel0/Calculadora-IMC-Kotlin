package com.unsatisfactorystudio.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.util.ArrayList
import kotlin.math.pow

class IacActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iac)
        //ad
        val adView = AdView(this)

        adView.adSize = AdSize.BANNER

        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        MobileAds.initialize(this) {}

        var mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        //codigo
        // spinner
        val spnIacSexo = findViewById<Spinner>(R.id.spnIacSexo)
        val listaSexo = arrayListOf<String>("Selecione o seu sexo", "Feminino", "Masculino")
        val sexoAdapter = ArrayAdapter(
            this,
            R.layout.style_spinner,
            listaSexo
        )
        spnIacSexo.adapter = sexoAdapter
        // capturar dados
        val cintura = findViewById<EditText>(R.id.edtIacCintura)
        val altura = findViewById<EditText>(R.id.edtIacAltura)
        val butIacCalcular = findViewById<Button>(R.id.btnIacCalcular)
        val txvResultado = findViewById<TextView>(R.id.edtIacResultado)
        butIacCalcular.setOnClickListener {
                hideKeyboard()
           val sexo = spnIacSexo.selectedItem.toString()
           val cintura1 = cintura.text.toString()
           val altura1 = altura.text.toString()
            if (cintura1.isEmpty()) {
                cintura.error = "Preencha o campo"
                cintura.requestFocus()
            }else if (altura1.isEmpty()) {
               altura.error = "Preencha o campo"
                altura.requestFocus()
            }else if (sexo == listaSexo[0]) {
                txvResultado.text = "Escolha o seu sexo"
            }else {
                val cintura2 = cintura1.toFloat()
                val altura2 = altura1.toDouble()
                val resultado = (cintura2 / (altura2/100).pow(1.5)) - 18
                val resultado2 =  String.format("%.2f", resultado)



                if (resultado in 8.0..20.0 && sexo == listaSexo[2]) {
                    txvResultado.text = """Seu IAC é de $resultado2
                    |
                    |É considerado normal segundo a tabela de interpretação do IAC.
                """.trimMargin()

                } else if (resultado in 21.0..25.0 && sexo == listaSexo[2]) {
                    txvResultado.text = """Seu IAC é de $resultado2
                    |
                    |Segundo a tabela de interpretação do IAC, você está com sobrepeso.
                """.trimMargin()
                }else if (resultado > 25.0 && sexo == listaSexo[2]) {
                    txvResultado.text = """Seu IAC é de $resultado2
                    |
                    |Segundo a tabela de interpretação do IAC, você está com obesidade.
                """.trimMargin()
                }else  if (resultado in 21.0..32.0 && sexo == listaSexo[1]) {
                    txvResultado.text = """Seu IAC é de $resultado2
                    |
                    |É considerado normal segundo a tabela de interpretação do IAC.
                """.trimMargin()

                } else if (resultado in 33.0..38.0 && sexo == listaSexo[1]) {
                    txvResultado.text = """Seu IAC é de $resultado2
                    |
                    |Segundo a tabela de interpretação do IAC, você está com sobrepeso.
                """.trimMargin()
                }else if (resultado > 38.0 && sexo == listaSexo[1]) {
                    txvResultado.text = """Seu IAC é de $resultado2
                    |
                    |Segundo a tabela de interpretação do IAC, você está com obesidade.
                """.trimMargin()
                }else if (resultado < 21 && sexo == listaSexo[1]) {
                    txvResultado.text = """Seu IAC é de $resultado2
                    |
                    |A tabela de interpretação de IAC femino, começa de 21 a 32 como normal, logo você esta abaixo do normal. 
                """.trimMargin()
                }else if (resultado < 8 && sexo == listaSexo[2]) {
                    txvResultado.text = """Seu IAC é de $resultado2
                    |
                    |A tabela de interpretação de IAC masculino, começa de 8 a 20 como normal, logo você esta abaixo do normal. 
                """.trimMargin()
                }




            }
            }
        }
    }
