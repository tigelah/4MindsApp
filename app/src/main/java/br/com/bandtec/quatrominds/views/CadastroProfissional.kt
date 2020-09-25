package br.com.bandtec.quatrominds.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.bandtec.quatrominds.R
import br.com.bandtec.quatrominds.storage.SessionManager
import kotlinx.android.synthetic.main.activity_cadastro_profissional.*
import kotlinx.android.synthetic.main.activity_login.senha
import kotlinx.android.synthetic.main.activity_login.username

class CadastroProfissional : AppCompatActivity() {


    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_profissional)


        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.cargos
            , android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        cargo.adapter = adapter

        sessionManager = SessionManager(this)

        btn_login.setOnClickListener {

            val email =  username.text.toString().trim()
            val password = senha.text.toString().trim()
            val tipo =  cargo.selectedItem.toString().trim()
            val name =  nome.text.toString().trim()
            val data =  datanasc.text.toString().trim()

//            val psicologo = Psicologo(name,tipo,data,email,password)
//
//
//            ClientFourMinds.instance.createUser(psicologo)
//                .enqueue(
//                    object : Callback<ResponseBody> {
//                        @SuppressLint("ShowToast")
//                        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//
//                            val headers: Headers = response.headers()
//                            // get header value
//                            // get header value
//                            val auth = response.headers()["Authorization"]
//                            Log.d("Body", call.request().toString())
//                            Log.d("Status Code",response.code().toString())
//                            Log.d("raw input",response.raw().toString())
//                            Log.d("Response",response.headers().toString())
//                            if (auth != null) {
//                                Log.d("Response",auth.substring(7))
//                            }
//
//
//                            if (response.isSuccessful) {
//
//                                if (auth != null) {
//                                    sessionManager.fetchAuthToken()
//                                }

                                Toast.makeText(applicationContext, "Cadastrado com sucesso !  ", Toast.LENGTH_LONG)

                                val intent = Intent(applicationContext, Login::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                                startActivity(intent)

//
//                            } else {
//                                Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_LONG)
//                                    .show()
//                            }
//
//                        }

//                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
//                        }
//                    })

        }
    }


}

