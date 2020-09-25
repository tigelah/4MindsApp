package br.com.bandtec.quatrominds.storage

import android.content.Context
import android.content.SharedPreferences
import br.com.bandtec.quatrominds.R
import br.com.bandtec.quatrominds.views.Agenda

class SessionManager (context: Context) {

    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val TOKEN = "Authorization"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(TOKEN, null)
    }
}