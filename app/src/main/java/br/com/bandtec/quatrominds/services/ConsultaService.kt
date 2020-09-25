package br.com.bandtec.quatrominds.services

import br.com.bandtec.quatrominds.model.Consulta

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface ConsultaService {

    @Headers( "Content-Type: application/json")
    @GET("consultas")
    fun consultas(@Header("Authorization")token: Any?): Call<List<Consulta>>

    @Headers( "Content-Type: application/json")
    @POST("consultas")
    fun agendarSessao(@Header("Authorization") token: Any?, @Body form: String): Call<ResponseBody>


}