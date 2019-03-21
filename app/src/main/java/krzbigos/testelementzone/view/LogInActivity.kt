package krzbigos.testelementzone.view

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_log_in.*
import krzbigos.testelementzone.R
import krzbigos.testelementzone.api.ResponseMenager
import krzbigos.testelementzone.services.SharedPrefKey
import krzbigos.testelementzone.interfaces.LogInInterface

class LogInActivity : AppCompatActivity(), LogInInterface {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            w.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
            )
        }
        val buttonLogin=findViewById<Button>(R.id.log_in_button)
        buttonLogin.setOnClickListener(View.OnClickListener {
            val responseMenager by lazy{ ResponseMenager() }
            val email=findViewById<EditText>(R.id.email_plain_text).text.toString()
            val password=findViewById<EditText>(R.id.password_plain_text).text.toString()
            responseMenager.getLoginToken(email,password,this)
        })

        val hidePasswordButton=findViewById<ImageView>(R.id.eye_image)
        hidePasswordButton.setOnClickListener(View.OnClickListener {
                password_plain_text.inputType=InputType.TYPE_CLASS_TEXT
        })
    }

    override fun onResume() {
        super.onResume()
        val sharedPrefKey= SharedPrefKey(applicationContext).getSharedPrefKey()
        if(!sharedPrefKey.equals("0")){
            login()
        }
    }

    override fun login() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    override fun setToken(key: String) {
        SharedPrefKey(applicationContext).setSharedPrefKey(key)
    }

}



