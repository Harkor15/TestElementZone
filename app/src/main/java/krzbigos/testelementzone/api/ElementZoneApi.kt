package krzbigos.testelementzone.api

import krzbigos.testelementzone.model.LoginData
import krzbigos.testelementzone.model.LoginResponse
import krzbigos.testelementzone.model.OrdersData
import krzbigos.testelementzone.model.OrdersResponse
import retrofit2.Call
import retrofit2.http.*

interface ElementZoneApi {
    @Headers("Content-Type: application/json","Accept: application/json")
    @POST("login")
    fun getResponse(@Body body: LoginData): Call<LoginResponse>

    @Headers("Content-Type: application/json","Accept: application/json")
    @POST("orders")
    fun getListOfOrders(@Body body: OrdersData): Call<OrdersResponse>
}