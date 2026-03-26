package com.programacionsistemasmoviles.exteriorfan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SalidaAdapter(private val lista: List<Salida>) :
    RecyclerView.Adapter<SalidaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.nombreSalida)
        val estado: TextView = view.findViewById(R.id.estadoSalida)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_salida, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val salida = lista[position]
        holder.nombre.text = salida.nombre
        holder.estado.text = salida.estado
    }

    override fun getItemCount(): Int = lista.size
}