package br.com.bandtec.quatrominds.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bandtec.quatrominds.R
import kotlinx.android.synthetic.main.fragment_financeiro.*


class Financeiro : Fragment() {

    val html = "https://app.powerbi.com/view?r=eyJrIjoiMWM5ODkzOGItNTA4OC00YTFkLTliNjYtNDc4YzJjMjQwMDEyIiwidCI6ImZkNTBiNDU3LTg0ZTAtNDAwYy04MGYyLTQ2MGYyOGViNDFhNiIsImMiOjR9"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_financeiro, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(html)
    }

}