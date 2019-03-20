package krzbigos.testelementzone.services

import android.util.Log
import krzbigos.testelementzone.api.RestAPI
import krzbigos.testelementzone.interfaces.OrderDetailsSendLinkInterface
import krzbigos.testelementzone.model.GenerateData
import krzbigos.testelementzone.model.GenerateResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class InviteLink(private  val api:RestAPI= RestAPI()){
    fun generateLinkToSend(orderDetailsSendLinkInterface: OrderDetailsSendLinkInterface, id:Int, key:String){
        val generateData=GenerateData(key,id.toString())
        val callResponse=api.generateInviteLink(generateData)
        callResponse.enqueue(object: Callback<GenerateResponse>{
            override fun onFailure(call: Call<GenerateResponse>, t: Throwable) {
                Log.v("Error", t.toString())
            }

            override fun onResponse(call: Call<GenerateResponse>, response: Response<GenerateResponse>) {
                val generateResponse=response.body()
                val link= generateResponse!!.data.link
                orderDetailsSendLinkInterface.sendLink(link)
            }
        })
    }
}