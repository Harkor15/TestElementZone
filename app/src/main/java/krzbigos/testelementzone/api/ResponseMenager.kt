package krzbigos.testelementzone.api

import android.util.Log
import krzbigos.testelementzone.api.LoginData
import krzbigos.testelementzone.api.LoginResponse
import krzbigos.testelementzone.api.RestAPI
import krzbigos.testelementzone.interfaces.LogInInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseMenager (private val api:RestAPI= RestAPI()){
    fun getLoginToken(email: String,password: String,logInInterface: LogInInterface){
        if(!email.equals("")||!password.equals("")){
            val loginData= LoginData(email,password)
            val callResponse = api.getResponse(loginData)
            callResponse.enqueue(object: Callback<LoginResponse>{
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.v("Error", t.toString())
                }
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    val loginResponse=response.body()
                    try {
                        val loginDataResponse = loginResponse!!.data
                        val key = loginDataResponse.api_token
                        logInInterface.setToken(key)
                        logInInterface.login()
                    }catch (e: KotlinNullPointerException){
                        Log.v("Error","Wrong login data")
                    }
                }
            })
        }
    }
}
