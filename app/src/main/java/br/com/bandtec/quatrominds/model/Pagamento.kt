package br.com.bandtec.quatrominds.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Pagamento(
    @JsonProperty("estado")
    val estado: Any? = null
)



