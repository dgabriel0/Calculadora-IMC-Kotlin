package com.unsatisfactorystudio.calculadoraimc

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import com.google.android.gms.ads.*


// função para baixar o teclado após o click

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}
fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val butImc = findViewById<Button>(R.id.btnImc)
        butImc.setOnClickListener{
            val mIntent = Intent(this, imcActivity :: class.java )
            startActivity(mIntent)

        }

        val adView = AdView(this)

        adView.adSize = AdSize.BANNER

        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        MobileAds.initialize(this) {}

        var mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)



        val butIcq = findViewById<Button>(R.id.btnIcq)
        butIcq.setOnClickListener {
            val mIntent = Intent(this, icqActivity :: class.java )
            startActivity(mIntent)
        }
        val butIac = findViewById<Button>(R.id.btnIac)
        butIac.setOnClickListener {
            val mIntent = Intent(this, IacActivity :: class.java )
            startActivity(mIntent)
        }
        val butUsp = findViewById<Button>(R.id.btnUsp)
        butUsp.setOnClickListener {
            val mIntent = Intent(this, UspActivity :: class.java )
            startActivity(mIntent)
        }
        val butSobre = findViewById<Button>(R.id.btnSobre)
        butSobre.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://linktr.ee/unsatisfactory") )
            startActivity(mIntent)
        }

    }
}