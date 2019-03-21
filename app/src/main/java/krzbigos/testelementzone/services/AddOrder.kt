package krzbigos.testelementzone.services

import android.util.Log
import krzbigos.testelementzone.api.RestAPI
import krzbigos.testelementzone.interfaces.ShopingListInterface
import krzbigos.testelementzone.model.AddOrderData
import krzbigos.testelementzone.model.AddOrderResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddOrder(private val api: RestAPI = RestAPI()) {
    fun addOrder(addOrderData: AddOrderData,shopingListInterface: ShopingListInterface){
        val callResponse = api.addOrder(addOrderData)
        callResponse.enqueue(object: Callback<AddOrderResponse> {
            override fun onFailure(call: Call<AddOrderResponse>, t: Throwable) {
                Log.v("Error",t.toString())
            }

            override fun onResponse(call: Call<AddOrderResponse>, response: Response<AddOrderResponse>) {
                if(response.isSuccessful){
                    shopingListInterface.openMenu()
                }
            }

        })

    }
}