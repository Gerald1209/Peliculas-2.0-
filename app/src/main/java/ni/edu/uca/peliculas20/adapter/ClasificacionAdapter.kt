package ni.edu.uca.peliculas20.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.peliculas20.databinding.ItemClasificacionBinding
import ni.edu.uca.peliculas20.entities.ClasificacionEntity

class ClasificacionAdapter(val list:List<ClasificacionEntity>): RecyclerView.Adapter<ClasificacionAdapter.ClasificacionViewHolder>(){

    private companion object DiffCallback : DiffUtil.ItemCallback<ClasificacionEntity>() {

        override fun areItemsTheSame(oldItem: ClasificacionEntity, newItem: ClasificacionEntity): Boolean =
            oldItem.idClasificacion == newItem.idClasificacion

        override fun areContentsTheSame(oldItem: ClasificacionEntity, newItem: ClasificacionEntity): Boolean =
            oldItem.abreviacion == newItem.abreviacion && oldItem.nombre == newItem.nombre

    }

    inner class ClasificacionViewHolder(private val binding: ItemClasificacionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cl : ClasificacionEntity) = binding.run {
            itemAbreviatura.text = cl.abreviacion
            itemId.text = cl.idClasificacion.toString()
            itemNombre.text = cl.nombre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClasificacionViewHolder =
        ClasificacionViewHolder(ItemClasificacionBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: ClasificacionViewHolder, position: Int) : Unit =
        holder.bind(list[position])

    override fun getItemCount(): Int =list.size
}