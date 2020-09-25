package br.com.bandtec.quatrominds.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Itens(
    @JsonProperty("psicologo")
    val psicologo: Psicologo? = null
)



