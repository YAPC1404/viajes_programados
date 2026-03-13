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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "principal"
            ){
                composable("Principal"){
                    PantallaPrincipal(navController)
                }
                composable("Crear"){
                    CrearSalidas(navController)
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal(navController: NavHostController){
    Column{
        Text("Pantalla principal")

        Button(onClick = {
            navController.navigate("Crear")
        }){
            Text("Crear salida")
        }
    }
}

@Composable
fun CrearSalidas(navController: NavHostController){
    Column{
        Text("Crear salida")

        Button(onClick = {
            navController.popBackStack()
        }){
            Text("Volver")
        }
    }
}