package com.example.rides.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rides.databinding.FragmentVehicleDetailsBinding


class VehicleDetailsFragment : Fragment() {

    private var binding: FragmentVehicleDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentVehicleDetailsBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        val vinNumber = arguments?.get("vin").toString()
        val model = arguments?.get("model").toString()
        val color = arguments?.get("color").toString()
        val type = arguments?.get("type").toString()

        binding!!.vin.text=vinNumber
        binding!!.model.text=model
        binding!!.color.text=color
        binding!!.carType.text=type


        return fragmentBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}