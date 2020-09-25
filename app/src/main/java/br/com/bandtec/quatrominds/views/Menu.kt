package br.com.bandtec.quatrominds.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import br.com.bandtec.quatrominds.R
import br.com.bandtec.quatrominds.model.Consulta
import br.com.bandtec.quatrominds.services.ClientFourMinds
import br.com.bandtec.quatrominds.storage.SessionManager
import kotlinx.android.synthetic.main.fragment_agenda.*
import kotlinx.android.synthetic.main.fragment_financeiro.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Menu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{



    private lateinit var sessionManager: SessionManager

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        getData()

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_agenda-> {
                val agenda = Agenda()
                sessionManager = SessionManager(this)
                val token = sessionManager.fetchAuthToken()
                val params = Bundle()
                params.putString("token",token)
                agenda.arguments = params
                supportFragmentManager.beginTransaction().replace(R.id.frame1,agenda).commit()
            }
            R.id.nav_ficha -> {
                val ficha = FichaClinica()
                supportFragmentManager.beginTransaction().replace(R.id.frame1,ficha).commit()
            }
            R.id.nav_cadastrar -> {
                val paciente = Paciente()
                supportFragmentManager.beginTransaction().replace(R.id.frame1,paciente).commit()
            }

            R.id.nav_finance -> {
                val financeiro = Financeiro()
                supportFragmentManager.beginTransaction().replace(R.id.frame1,financeiro).commit()
            }
            R.id.nav_sair -> {
                Toast.makeText(this, "Saindo da sessao", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Login::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    private fun getData(){


        sessionManager = SessionManager(this)

       val token = sessionManager.fetchAuthToken()

        Log.d("Token", token)

            ClientFourMinds.endpoint.consultas(token)
                .enqueue(
                    object : Callback<List<Consulta>> {
                        override fun onResponse(call: Call<List<Consulta>>, response: Response<List<Consulta>>) {
                            Log.d("Body", call.request().toString())
                            Log.d("Status Code",response.code().toString())
                            Log.d("Corpo da Resposta", response.body()?.get(0)?.dataConsulta.toString())



                            val params = Bundle()

                            response.body()?.forEach {
                                params.putString("dataconsulta", response.body()?.get(0)?.dataConsulta.toString())
                                params.putString("Nome", response.body()?.get(0)?.paciente?.nome.toString())
                                params.putString("pagamento", response.body()?.get(0)?.pagamento?.estado.toString())
                            }

                            val fragmento = Consultas()
                            fragmento.arguments = params

                            supportFragmentManager.beginTransaction().replace(R.id.frame1,fragmento).commit()


                        }
                        override fun onFailure(call: Call<List<Consulta>>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                            Log.d("Body", call.request().toString())
                            Log.d("Erro", t.message)
                        }
                    })

        }

    fun retornaMenu (v : View){
        val intent = Intent(applicationContext, Menu::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }



}
