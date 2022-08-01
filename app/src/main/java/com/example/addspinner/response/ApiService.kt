package com.example.addspinner.response

import com.example.addspinner.json.ResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/dashboard/targetVsActual")
    fun getService(@Query("tuid") query:String): Call<ResponseDTO>
}