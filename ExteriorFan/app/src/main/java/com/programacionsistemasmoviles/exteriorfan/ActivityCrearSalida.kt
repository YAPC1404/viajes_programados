package com.programacionsistemasmoviles.exteriorfan

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.DatePickerDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.view.View
import android.widget.Switch
import android.widget.LinearLayout
import android.widget.Button
import android.widget.Toast

class ActivityCrearSalida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crear_salida)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etFecha = findViewById<EditText>(R.id.etFecha)
        val switchTipo = findViewById<Switch>(R.id.switchTipoSalida)
        val layoutDias = findViewById<LinearLayout>(R.id.layoutDias)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        etFecha.visibility = View.GONE
        layoutDias.visibility = View.VISIBLE
        switchTipo.isChecked = true

        switchTipo.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                // Salida temporal
                etFecha.visibility = View.VISIBLE
                layoutDias.visibility = View.GONE
            } else {
                // Salida recurrente
                etFecha.visibility = View.GONE
                layoutDias.visibility = View.VISIBLE
            }

        etFecha.setOnClickListener {
            val calendario = Calendar.getInstance()
            val anio = calendario.get(Calendar.YEAR)
            val mes = calendario.get(Calendar.MONTH)
            val dia = calendario.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, year, month, dayOfMonth ->
                val fechaSeleccionada = "$dayOfMonth/${month + 1}/$year"
                etFecha.setText(fechaSeleccionada)
            }, anio, mes, dia)

            datePicker.show()
        }

        val etHoraEntrada = findViewById<EditText>(R.id.etHoraEntrada)
        val etHoraSalida = findViewById<EditText>(R.id.etHoraSalida)

        // Hora de entrada
        etHoraEntrada.setOnClickListener {
            val calendario = Calendar.getInstance()
            val hora = calendario.get(Calendar.HOUR_OF_DAY)
            val minuto = calendario.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this, { _, hourOfDay, minute ->
                val horaFormateada = String.format("%02d:%02d", hourOfDay, minute)
                etHoraEntrada.setText(horaFormateada)
            }, hora, minuto, true)

            timePicker.show()
        }

        // Hora de salida
        etHoraSalida.setOnClickListener {
            val calendario = Calendar.getInstance()
            val hora = calendario.get(Calendar.HOUR_OF_DAY)
            val minuto = calendario.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this, { _, hourOfDay, minute ->
                val horaFormateada = String.format("%02d:%02d", hourOfDay, minute)
                etHoraSalida.setText(horaFormateada)
            }, hora, minuto, true)

            timePicker.show()
        }
        }

        btnGuardar.setOnClickListener {
            Toast.makeText(this, "Salida creada", Toast.LENGTH_SHORT).show()
        }
    }
}