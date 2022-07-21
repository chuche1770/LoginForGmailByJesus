package com.example.loginforgmailbyjesus

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UserRegistration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registration)


        //Encontramos los componentes
        val etNombre=findViewById<EditText>(R.id.etUsuario)
        val etCorreo=findViewById<EditText>(R.id.etCorreo)
        val etPass=findViewById<EditText>(R.id.etContrasena)
        val etConfirmPass=findViewById<EditText>(R.id.etConfirmContrasena)
        val btnCrearCuenta=findViewById<Button>(R.id.btnGuardar)

        btnCrearCuenta.setOnClickListener(View.OnClickListener {

            //Igualamos las variables a el contenido de los EditText
            val nombreCuneta:String=etNombre.text.toString()
            val correo:String=etCorreo.text.toString()
            val pass:String=etPass.text.toString()
            val confirmPass:String=etConfirmPass.text.toString()

            //Validamos que ningún campo se encuentre vacío
            if (nombreCuneta.equals("")||correo.equals("")||pass.equals("")||confirmPass.equals("")){
                Toast.makeText(this,"Es Necesario llenar todos los campos para crear la cuenta",Toast.LENGTH_SHORT).show()
            }else{
                if(pass.equals(confirmPass)){
                    //Si las contraseñas coinciden guaradamos las SharedPreferences
                    val nameSharedP="userData"
                    val spRegisro:SharedPreferences=this.getSharedPreferences(nameSharedP, Context.MODE_PRIVATE)
                    val editor:SharedPreferences.Editor=spRegisro.edit()
                    editor.putString("nombreUsuario",nombreCuneta)
                    editor.putString("contrasenaUsuario",pass)
                    editor.putString("correoUsuario",correo)
                    editor.apply()
                    editor.commit()

                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(this,"Las contraseñas no coindiden",Toast.LENGTH_SHORT).show()
                    etPass.setText("")
                    etConfirmPass.setText("")
                }
            }


        })

    }
}