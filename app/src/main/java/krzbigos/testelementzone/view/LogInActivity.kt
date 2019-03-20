package krzbigos.testelementzone.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import krzbigos.testelementzone.R
import krzbigos.testelementzone.api.ResponseMenager
import krzbigos.testelementzone.services.SharedPrefKey
import krzbigos.testelementzone.interfaces.LogInInterface

class LogInActivity : AppCompatActivity(), LogInInterface {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        refresh()
        val buttonLogin=findViewById<Button>(R.id.log_in_button)
        buttonLogin.setOnClickListener(View.OnClickListener {
            val responseMenager by lazy{ ResponseMenager() }
            val email=findViewById<EditText>(R.id.email_plain_text).text.toString()
            val password=findViewById<EditText>(R.id.password_plain_text).text.toString()
            responseMenager.getLoginToken(email,password,this)
        })

    }
    override fun login() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    override fun setToken(key: String) {
        SharedPrefKey(applicationContext).setSharedPrefKey(key)
    }
    private fun refresh(){
        val sharedPrefKey= SharedPrefKey(applicationContext).getSharedPrefKey()
        if(!sharedPrefKey.equals("0")){
            login()
        }
    }

}



