package br.com.bandtec.quatrominds.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty

data class Paciente (
    @JsonProperty("nome")
    val nome: String? = null,

    @JsonProperty("email")
    val email: String? = null,

    @JsonProperty("cpfOuCnpj")
    val cpfOuCnpj: String? = null,

    @JsonProperty("tipo")
    val tipo: Any? = null,

    @JsonProperty("estadoCivil")
    val estadoCivil: String? = null,

    @JsonProperty("sexo")
    val sexo: String? = null,

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("dataNascimento")
    val dataNascimento: Any? = null,

    @JsonProperty("telefone1")
    val telefone1: String? = null,

    @JsonProperty("telefone2")
    val telefone2: String? = null,

    @JsonProperty("logradouro")
    val logradouro: String? = null,

    @JsonProperty("numero")
    val numero: String? = null,

    @JsonProperty("complemento")
    val complemento: String? = null,

    @JsonProperty("bairro")
    val bairro: String? = null,

    @JsonProperty("cep")
    val cep: String? = null,

    @JsonProperty("cidadeId")
    val cidadeId: Any? = null)