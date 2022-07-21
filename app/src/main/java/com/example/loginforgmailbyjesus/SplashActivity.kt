package com.example.loginforgmailbyjesus

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val spSesion:SharedPreferences=getSharedPreferences("Session",0)
        val sesionActiva:Boolean=spSesion.getBoolean("sesionActiva",false)
        if (sesionActiva){
            startActivity(Intent(this,MainActivity::class.java))

        }else{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()



    }
}