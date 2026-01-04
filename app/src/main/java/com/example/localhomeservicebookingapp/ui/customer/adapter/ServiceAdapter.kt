package com.example.localhomeservicebookingapp.ui.customer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.localhomeservicebookingapp.R
import com.example.localhomeservicebookingapp.model.Service

class ServiceAdapter(
    private val services: List<Service>
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    class ServiceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgService)
        val name: TextView = view.findViewById(R.id.tvServiceName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_service, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = services[position]
        holder.name.text = service.name
        holder.img.setImageResource(service.icon)
    }

    override fun getItemCount(): Int = services.size
}
