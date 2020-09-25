package br.com.bandtec.quatrominds.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bandtec.quatrominds.R
import kotlinx.android.synthetic.main.fragment_consultas.*


class Consultas : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consultas, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvInterna.text = "Nome Paciente: ${arguments?.get("Nome")}"
        tvInterna2.text = "Data/Hora Consulta: ${arguments?.get("dataconsulta")}"
        etTeste.text = "Estado do Pagamento: ${arguments?.get("pagamento")}"

    }





}