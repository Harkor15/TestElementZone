package krzbigos.testelementzone.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestAPI {

    private val elementZoneApi: ElementZoneApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://test.elementzone.uk")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        elementZoneApi=retrofit.create(ElementZoneApi::class.java)
    }

    fun getResponse(body:LoginData): Call<LoginResponse>{
        return elementZoneApi.getResponse(body)
    }
}