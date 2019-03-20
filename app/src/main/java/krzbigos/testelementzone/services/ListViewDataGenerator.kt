package krzbigos.testelementzone.services

import android.util.Log
import krzbigos.testelementzone.api.RestAPI
import krzbigos.testelementzone.interfaces.CustomAdapterInterface
import krzbigos.testelementzone.model.OrdersData
import krzbigos.testelementzone.model.OrdersResponse
import krzbigos.testelementzone.model.SingleOrder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.NullPointerException

class ListViewDataGenerator(private val api:RestAPI= RestAPI()) {
    fun getListViewData(token: String,customAdapterInterface:CustomAdapterInterface){
        val ordersData= OrdersData(token,1,10 )
        val callResponse: Call<OrdersResponse> = api.getListOfOrders(ordersData)
        callResponse.enqueue(object: Callback<OrdersResponse>{
            override fun onFailure(call: Call<OrdersResponse>, t: Throwable) {
                Log.v("Error", t.toString())
            }

            override fun onResponse(call: Call<OrdersResponse>, response: Response<OrdersResponse>) {
                val orderResponse: OrdersResponse?= response.body()
                try{
                    val orderList:List<SingleOrder> = orderResponse!!.data
                    customAdapterInterface.completeListView(orderList)
                }catch (e: NullPointerException){
                    Log.v("Error",e.toString())
                }
            }
        })

    }
}
