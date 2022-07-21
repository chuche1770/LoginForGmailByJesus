package com.example.loginforgmailbyjesus

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {




    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val spLogin:SharedPreferences=getSharedPreferences("userData", Context.MODE_PRIVATE)

        //Componentes visuales y variables
        val inputUser=findViewById<EditText>(R.id.etUsuario)
        val inputPass=findViewById<EditText>(R.id.etContrasena)
        val btnReg=findViewById<TextView>(R.id.txtRegistrar)
        val btnLogIn=findViewById<Button>(R.id.btnIniciar)

        //Asignamos el valor de las SharedPreferences con su llave(key) a las variables
        val sMail: String? =spLogin.getString("correoUsuario","")
        val sPassWord:String?=spLogin.getString("contrasenaUsuario","")
        val sUser:String?=spLogin.getString("nombreUsuario","")

        Toast.makeText(this,"El Correo es :" +sMail.toString(),Toast.LENGTH_LONG).show()



        btnReg.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, UserRegistration::class.java))
            inputUser.setText("")
            inputPass.setText("")
        })

        btnLogIn.setOnClickListener(View.OnClickListener {
            //Igualamos las variables al contenido de los EditText
            val inMail:String= inputUser.text.toString()
            val inPass:String=inputPass.text.toString()

            //Validamos que los campos Usuario y Contrasena no estén vacíos

            if (inMail.isEmpty()||inPass.isEmpty()){
                Toast.makeText(this,"Por favor, ingresa el correo y la contraseña",Toast.LENGTH_SHORT).show()
            }else{
                //Validamos que el usuario y contrasena coincidan con los valores guardados en las SP
                if (inMail.equals(sMail)&&inPass.equals(sPassWord)){
                    //Si el usuario coicide , entonces pasarameos a la MainActivity
                    val spSesion:SharedPreferences=getSharedPreferences("Session",0)
                    val editor:SharedPreferences.Editor=spSesion.edit()
                    editor.putBoolean("sesionActiva",true)
                    editor.apply()

                    Toast.makeText(this,"Bienvenido "+sUser.toString(),Toast.LENGTH_SHORT).show()
                    val venatana:Intent=Intent(this,MainActivity::class.java)
                    venatana.putExtra("sUsuario",sUser)
                    venatana.putExtra("sCorreo",sMail)

                    startActivity(venatana)
                    finish()

                }else{
                    Toast.makeText(this,"Datos Incorrectos, revisa el correo y/o contraseña",Toast.LENGTH_SHORT).show()
                }
            }
        })




    }


    //Método para ocultar el teclado
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val inputUser=findViewById<EditText>(R.id.etUsuario)
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(inputUser.getWindowToken(), 0)
        return super.onTouchEvent(event)
    }
}