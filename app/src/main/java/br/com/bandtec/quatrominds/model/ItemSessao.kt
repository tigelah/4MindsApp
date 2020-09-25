package br.com.bandtec.quatrominds.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ItemSessao(
    @JsonProperty("psicologo")
    val psicologo: Psicologo? = null
)

