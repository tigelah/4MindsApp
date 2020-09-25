package br.com.bandtec.quatrominds.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.bandtec.quatrominds.R

class EsqueciSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci_senha)
    }

    fun retornaLogin (v : View){
        Toast.makeText(applicationContext, "Senha enviada no email verifique sua caixa de Entrada!  ", Toast.LENGTH_LONG)
        val intent = Intent(applicationContext, Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}

