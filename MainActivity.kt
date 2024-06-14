package com.proyecto.agendainteligente

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.proyecto.agendainteligente.util.PreferenceHelper
import com.proyecto.agendainteligente.util.PreferenceHelper.get
import com.proyecto.agendainteligente.util.PreferenceHelper.set

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.InicioActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        val preferences = PreferenceHelper.defaultPrefs(context = this)
        if (preferences["session", false])
            goToMenu()


        val tvGoRegister = findViewById<TextView>(R.id.tv_go_to_login)
        tvGoRegister.setOnClickListener(){
            goToRegister()

        }

        val buttonGoInicio = findViewById<Button>(R.id.buttonsession)
        buttonGoInicio.setOnClickListener(){
            goToMenu()

        }

    }
    private fun goToRegister(){
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }

    private fun goToMenu(){
        val i = Intent(this, inicio_activity::class.java)
        createSessionPreferences()
        startActivity(i)
        finish()
    }

    private fun createSessionPreferences(){
        val preferences = PreferenceHelper.defaultPrefs(context=this)
        preferences["session"] = true

    }
}