package br.com.bandtec.quatrominds.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class Consulta(
    @SerializedName("dataConsulta")
    @JsonProperty("dataConsulta")
    val dataConsulta: Any? = null,

    @SerializedName("paciente")
    @JsonProperty("paciente")
    val paciente: Paciente? = null,

    @SerializedName("pagamento")
    @JsonProperty("pagamento")
    val pagamento: Pagamento? = null,


    @SerializedName("enderecoDeConsulta")
    @JsonProperty("enderecoDeConsulta")
    val enderecoDeConsulta: Any? = null,

    @SerializedName("valorTotal")
    @JsonProperty("valorTotal")
    val valorTotal: Any? = null

)








