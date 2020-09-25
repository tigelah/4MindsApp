package br.com.bandtec.quatrominds.services


import br.com.bandtec.quatrominds.model.Paciente
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface PacienteService {

    @Headers( "Content-Type: application/json")
    @GET("pacientes")
    fun pacientes(): Call<List<Paciente>>

    @Headers( "Content-Type: application/json")
    @GET("pacientes/{id}")
    fun pacientesPoId(@Header("Authorization")token: Any?, @Path("id") id: Int): Call<List<Paciente>>


    @Headers( "Content-Type: application/json")
    @POST("pacientes")
    fun cadastrarPaciente(@Header("Authorization")token: Any?, @Body form: Paciente): Call<ResponseBody>

}