package br.com.bandtec.quatrominds.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty

data class Psicologo (
    @JsonProperty("nome")
    val nome: String? = null,

    @JsonProperty("cargo")
    val cargo: String? = null,

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("dataNascimento")
    val dataNascimento: Any? = null,

    @JsonProperty("email")
    val email: String? = null,

    @JsonProperty("password")
    val password: String? = null)