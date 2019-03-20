package krzbigos.testelementzone.api

import com.google.gson.GsonBuilder
import krzbigos.testelementzone.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestAPI {
    private val elementZoneApi: ElementZoneApi
    init {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd").create()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://test.elementzone.uk")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        elementZoneApi=retrofit.create(ElementZoneApi::class.java)
    }

    fun getResponse(body: LoginData): Call<LoginResponse>{
        return elementZoneApi.getResponse(body)
    }
    fun getListOfOrders(body: OrdersData): Call<OrdersResponse>{
        return elementZoneApi.getListOfOrders(body)
    }
    fun generateInviteLink(body: GenerateData): Call<GenerateResponse>{
        return elementZoneApi.generateInviteLink(body)
    }

}