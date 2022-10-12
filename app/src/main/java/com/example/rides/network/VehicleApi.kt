package com.example.rides.network
import com.example.rides.model.VehicleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface VehicleApi {

    @GET("vehicle/random_vehicle")
    fun getVehicleList(@Query("size") size: Int): Call<MutableList<VehicleResponse>>





}