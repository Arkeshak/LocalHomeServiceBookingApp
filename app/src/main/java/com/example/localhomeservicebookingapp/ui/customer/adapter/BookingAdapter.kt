package com.example.localhomeservicebookingapp.ui.customer.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.localhomeservicebookingapp.R
import com.example.localhomeservicebookingapp.BookingDetailsActivity
import com.example.localhomeservicebookingapp.ui.customer.model.Booking

class BookingAdapter(
    private val context: Context,
    private val bookings: List<Booking>
) : RecyclerView.Adapter<BookingAdapter.BookingViewHolder>() {

    inner class BookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvService: TextView = itemView.findViewById(R.id.tvService)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_booking, parent, false)
        return BookingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val booking = bookings[position]

        holder.tvService.text = booking.service
        holder.tvDate.text = booking.date
        holder.tvLocation.text = booking.location
        holder.tvStatus.text = booking.status

        holder.itemView.setOnClickListener {
            val intent = Intent(context, BookingDetailsActivity::class.java)
            intent.putExtra("service", booking.service)
            intent.putExtra("date", booking.date)
            intent.putExtra("location", booking.location)
            intent.putExtra("status", booking.status)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = bookings.size
}
