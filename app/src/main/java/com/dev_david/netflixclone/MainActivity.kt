package com.dev_david.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            AbrirTelaLogin()
        },2000)
    }

    private fun AbrirTelaLogin(){
        val intent = Intent(this,FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}