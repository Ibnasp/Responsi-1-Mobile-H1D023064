package com.example.responsi1mobile.data.network

import com.example.responsi1mobile.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {
    @GET("teams/{id}")
    suspend fun getTeamData(
        @Path("id") id: Int = 89,
        @Header("X-Auth-Token") token: String = "98d388bd2a1b494ab6dbdc5e7ab2bd68"
    ): Response<TeamResponse>
}