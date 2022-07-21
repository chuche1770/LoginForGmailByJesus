package com.example.loginforgmailbyjesus

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSesionOut=findViewById<Button>(R.id.btnCerrarS)

        btnSesionOut.setOnClickListener(View.OnClickListener {
            val spSesion:SharedPreferences=getSharedPreferences("Session",0)
            val edittor:SharedPreferences.Editor=spSesion.edit()
            edittor.putBoolean("sesionActiva",false)
            edittor.apply()

            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        })

    }
}