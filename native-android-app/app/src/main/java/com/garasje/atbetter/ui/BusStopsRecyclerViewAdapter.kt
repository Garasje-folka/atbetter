package com.garasje.atbetter.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.garasje.atbetter.R
import com.garasje.atbetter.core.BusStop

class BusStopsRecyclerViewAdapter(val onClick: (busStop: BusStop) -> Unit): RecyclerView.Adapter<BusStopsRecyclerViewAdapter.ViewHolder>() {

    private val busStops = ArrayList<BusStop>()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView1)
        val cardView: CardView = itemView.findViewById(R.id.card1)

    }

    fun addBusStop( busStop: BusStop) {
        this.busStops.add(busStop)
        notifyItemInserted(busStops.indexOf(busStop))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.bus_stop_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = busStops[position].name
        holder.cardView.setOnClickListener {
            onClick(busStops[position])
        }

    }

    override fun getItemCount(): Int {
        return busStops.size
    }

}