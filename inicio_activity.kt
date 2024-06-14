package com.proyecto.agendainteligente

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.proyecto.agendainteligente.util.PreferenceHelper
import com.proyecto.agendainteligente.util.PreferenceHelper.set
import ui.CreateAppointmentActivity1

class inicio_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.InicioActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnLogout = findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener{
            clearSessionPreferences()
            goToLogin()

        }

        val btnOption1 = findViewById<Button>(R.id.btn_activity)
        btnOption1.setOnClickListener{
            clearSessionPreferences()
            goToOption1()

        }
    }

    private fun goToLogin(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }

    private fun clearSessionPreferences(){
        val preferences = PreferenceHelper.defaultPrefs(context=this)
        preferences["session"] = false

    }

    private fun goToOption1(){
        val i = Intent(this, CreateAppointmentActivity1::class.java)
        startActivity(i)
        finish()
    }

}
