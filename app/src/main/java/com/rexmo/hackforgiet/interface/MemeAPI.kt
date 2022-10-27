package com.rexmo.hackforgiet.`interface`

import com.rexmo.hackforgiet.data.Auth
import com.rexmo.hackforgiet.data.memeData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MemeAPI {
    @GET("/gimme")
    suspend fun getMeme() : Response<memeData>
}