package krzbigos.testelementzone.api

import retrofit2.Call
import retrofit2.http.*

interface ElementZoneApi {
    @Headers("Content-Type: application/json","Accept: application/json")
    @POST("login")
    fun getResponse(@Body body: LoginData): Call<LoginResponse>
}