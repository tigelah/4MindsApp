package br.com.bandtec.quatrominds.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.bandtec.quatrominds.R
import br.com.bandtec.quatrominds.services.ClientFourMinds
import br.com.bandtec.quatrominds.storage.SessionManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_agenda.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.fragment_agenda.nomePacienteAgenda as nomePacienteAgenda1


class Agenda : Fragment() {

    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agenda, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        btn_buscar.setOnClickListener {

            val buscar = etBuscar.text.toString()

            var nome:String? = "Juliana Monteiro"

            if (buscar.equals("Juliana Monteiro")) {
                nomePacienteAgenda1?.text = "Juliana Monteiro"
                dtNascPac?.text = "05/11/1991"
                emailAgendaPac?.text = "peroladaju@gmail.com"
                cepAgenda?.text = "38220834"
                dataAgendamento.setText("22/02/2020 05:58")
                valorAgendamento.text = "R$ 200,00"
            }
            Thread.sleep(500)
            nomePacienteAgenda1.setEnabled(false)
            dtNascPac.setEnabled(false)
            emailAgendaPac.setEnabled(false)
            cepAgenda.setEnabled(false)
            sexoAgenda.setEnabled(false)
            dataAgendamento.setEnabled(false)
            valorAgendamento.setEnabled(false)

        }

        btn_agendar.setOnClickListener{

            val gsonPretty = GsonBuilder().setPrettyPrinting().create()

           val form : Map<String, Any> =
            mapOf("paciente" to listOf("id" to 1),
                "enderecoDeConsulta" to listOf("id" to 1),
                "pagamento" to listOf(
                    "numeroDeParcelas" to 5,
                    "@type" to "pagamentoComCartao"),
                    "itens" to listOf(
                        "quantidade" to 1,
                        "psicologo" to listOf<Any>("id" to 1))
            )

            val jsonFormPretty: String = gsonPretty.toJson(form)


//            val form = """{
//    \"paciente\": {
//        \"id\": 1
//    },
//    \"enderecoDeConsulta\": {
//        \"id\": 1
//    },
//    \"pagamento\": {
//        \"numeroDeParcelas\": 5,
//        \"@type\": "pagamentoComCartao"
//    },
//    \"itens\": [
//        {
//            \"quantidade\": 1,
//            \"psicologo\": {
//                \"id\": 1
//            }
//        }
//
//    ]
//}""".trimMargin())


            ClientFourMinds.endpoint.agendarSessao(arguments?.get("token"),jsonFormPretty)
                .enqueue(
                    object : Callback<ResponseBody> {
                        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                            Log.d("Body", call.request().toString())
                            Log.d("Status Code",response.code().toString())
                            Log.d("raw input",response.raw().toString())
                            Log.d("Response",response.headers().toString())

                            Toast.makeText(context, "Agendado com sucesso verifique o email", Toast.LENGTH_SHORT).show()

                        }
                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                            Toast.makeText(context, "Erro " + t.message , Toast.LENGTH_SHORT).show()
                        }
                    })

        }

        }




    }

