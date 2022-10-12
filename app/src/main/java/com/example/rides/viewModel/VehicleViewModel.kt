package com.example.rides.viewModel
import android.util.Log
import androidx.lifecycle.*
import com.example.rides.model.VehicleResponse
import com.example.rides.network.VehicleApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehicleViewModel(): ViewModel(),
    Callback<MutableList<VehicleResponse>>{

    val vehicleList = MutableLiveData<MutableList<VehicleResponse>>()
    val errorMessage = MutableLiveData<String>()


    fun makeApiCall(size: Int) {
        WebServiceClient.client.create(VehicleApi::class.java).getVehicleList(size).enqueue(this)

    }

    override fun onResponse(
        call: Call<MutableList<VehicleResponse>>,
        response: Response<MutableList<VehicleResponse>>
    ) {
        vehicleList.postValue(response.body())

    }

    override fun onFailure(call: Call<MutableList<VehicleResponse>>, t: Throwable) {
        Log.e("Error :", t.message.toString())
        errorMessage.postValue(t.message)
    }


}




