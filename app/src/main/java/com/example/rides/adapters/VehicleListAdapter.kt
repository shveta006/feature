package com.example.rides.adapters

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.rides.R
import com.example.rides.databinding.LayoutVehicleListBinding
import com.example.rides.model.VehicleResponse


class VehicleListAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var list = mutableListOf<VehicleResponse>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateVehicleList(vehicle: List<VehicleResponse>) {
        this.list.clear()
        this.list = vehicle.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutVehicleListBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val vehicle = list[position]
        holder.binding.model.text= vehicle.make_and_model
        holder.binding.vin.text= vehicle.vin

        holder.binding.root.setOnClickListener {

            val bundle = Bundle()
                bundle.putString("vin",vehicle.vin )
                bundle.putString("model",vehicle.make_and_model )
                bundle.putString("color",vehicle.color )
                bundle.putString("type",vehicle.car_type )
                bundle.putInt("kilometre",vehicle.kilometrage )
            Navigation.findNavController(it).navigate(R.id.vehicleDetailFragment,bundle)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MainViewHolder(val binding: LayoutVehicleListBinding) : RecyclerView.ViewHolder(binding.root) {

}