package krzbigos.testelementzone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        val buttonLogin=findViewById<Button>(R.id.log_in_button)
        buttonLogin.setOnClickListener(View.OnClickListener {
            val responseMeneger by lazy{ResponseMenager()}
            val email=findViewById<EditText>(R.id.email_plain_text).text.toString()
            val password=findViewById<EditText>(R.id.password_plain_text).text.toString()
            responseMeneger.getLoginToken(email,password)

        })

    }
}



