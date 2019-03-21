package krzbigos.testelementzone.api

import krzbigos.testelementzone.model.*
import retrofit2.Call
import retrofit2.http.*

interface ElementZoneApi {
    @Headers("Content-Type: application/json","Accept: application/json")
    @POST("login")
    fun getResponse(@Body body: LoginData): Call<LoginResponse>

    @Headers("Content-Type: application/json","Accept: application/json")
    @POST("orders")
    fun getListOfOrders(@Body body: OrdersData): Call<OrdersResponse>

    @Headers("Content-Type: application/json","Accept: application/json")
    @POST("generate")
    fun generateInviteLink(@Body body: GenerateData): Call<GenerateResponse>

    @Headers("Content-Type: application/json","Accept: application/json")
    @POST("addOrder")
    fun addOrder(@Body body: AddOrderData): Call<AddOrderResponse>
}