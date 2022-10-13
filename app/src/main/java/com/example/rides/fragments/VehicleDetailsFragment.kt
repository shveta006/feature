package com.example.rides.fragments
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rides.databinding.FragmentVehicleDetailsBinding


class VehicleDetailsFragment : Fragment() {

    private var binding: FragmentVehicleDetailsBinding? = null

    @SuppressLint("SetTextI18n")
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
        val kilometre = arguments?.getInt("kilometre")

        binding!!.vin.text="Vin -> $vinNumber"
        binding!!.model.text="Model -> $model"
        binding!!.color.text="Color -> $color"
        binding!!.carType.text="Car Type -> $type"
        binding!!.bottomLayout.tvTitle.text=kilometre.toString()

        if (kilometre != null) {
            getCarbonEmitted(kilometre)
        }



        return fragmentBinding.root
    }

    @SuppressLint("SetTextI18n")
    private fun getCarbonEmitted(kilometre: Int) {

        var carbonEmitted=0
        if(kilometre<5000 || kilometre==5000)
        {
            carbonEmitted=kilometre*1
            binding!!.bottomLayout.tvTitle.text="Carbon Emitted Units -> $carbonEmitted"
        }
        else if(kilometre>5001)
        {
            val moreKilometers=kilometre-5000
            carbonEmitted= ((moreKilometers*1.5)+5000).toInt()
            binding!!.bottomLayout.tvTitle.text= "Carbon Emitted Units-> $carbonEmitted"


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}