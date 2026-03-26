package com.programacionsistemasmoviles.exteriorfan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.savedstate.serialization.saved
import androidx.navigation.compose.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.content.Intent
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Conectar XML
        setContentView(R.layout.pantalla_principal)
        val recycler = findViewById<RecyclerView>(R.id.recyclerSalidas)

        recycler.layoutManager = LinearLayoutManager(this)

        val lista = listOf(
            Salida("Ir al trabajo", "A tiempo"),
            Salida("Ir al gym", "Retrasado"),
            Salida("Ir a la escuela", "A tiempo")
        )

        val adapter = SalidaAdapter(lista)
        recycler.adapter = adapter

        val iconConfig = findViewById<ImageView>(R.id.iconConfig)

        iconConfig.setOnClickListener {
            val intent = Intent(this, ConfiguracionActivity::class.java)
            startActivity(intent)
        }
    }
}