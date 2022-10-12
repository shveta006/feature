package com.example.rides.fragments
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rides.adapters.VehicleListAdapter
import com.example.rides.databinding.FragmentVehicleListBinding
import com.example.rides.model.VehicleResponse
import com.example.rides.viewModel.VehicleViewModel



class VehicleListFragment : Fragment() {

    private var binding: FragmentVehicleListBinding? = null
    private lateinit var viewModel: VehicleViewModel
    private val adapter = VehicleListAdapter()
    private var vehicleList = mutableListOf<VehicleResponse>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentVehicleListBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding!!.recyclerView.adapter = adapter

       if(vehicleList.size>0)
        {
            adapter.updateVehicleList(vehicleList)
        }



            binding!!.submitButton.setOnClickListener {

                val sizeString=binding!!.binaryCurrency.text.toString()
                Log.d("SizeSTring", sizeString)

                if(sizeString.isNotBlank() || sizeString.isNotEmpty())
                {
                    val size=sizeString.toInt()
                    viewModel=ViewModelProvider(this)[VehicleViewModel::class.java]
                    viewModel.vehicleList.observe(viewLifecycleOwner, Observer { it ->



                        val sortByVin = it.sortedBy { it.vin }

                        if(it.size==0)
                        {
                            Toast.makeText(context, "Please enter valid number", Toast.LENGTH_SHORT).show()
                        }
                        else
                        {
                            vehicleList= sortByVin as MutableList<VehicleResponse>
                        }

                        adapter.updateVehicleList(sortByVin)
                    })

                    viewModel.errorMessage.observe(viewLifecycleOwner, Observer {




                    })

                    viewModel.makeApiCall(size)
                }
                else
                {
                    Toast.makeText(context, "Please enter the number", Toast.LENGTH_SHORT).show()
                }
            }

        return fragmentBinding.root
    }

   override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}