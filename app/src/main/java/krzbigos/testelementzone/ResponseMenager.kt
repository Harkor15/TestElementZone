package krzbigos.testelementzone

import android.util.Log
import krzbigos.testelementzone.api.LoginData
import krzbigos.testelementzone.api.LoginResponse
import krzbigos.testelementzone.api.RestAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseMenager (private val api:RestAPI= RestAPI()){

    fun getLoginToken(email: String,password: String){
        val loginData= LoginData(email,password)
        val callResponse = api.getResponse(loginData)

        callResponse.enqueue(object: Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.v("Errorokmijn", t.toString())
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
               Log.d("responseokmijn",response.toString())
                val loginResponse=response.body()
                val loginDataResponse = loginResponse!!.data
                val key = loginDataResponse.api_token
            }
        })
    }
}
