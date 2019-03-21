package krzbigos.testelementzone.view

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import krzbigos.testelementzone.R
import java.util.*

class ShopDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_data)
        val shoppingDate=findViewById<EditText>(R.id.shopping_date_edit)

        val nextStepButton=findViewById<Button>(R.id.next_step_button)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        shoppingDate.setOnClickListener(View.OnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                shoppingDate.setText("$year-$monthOfYear-$dayOfMonth")
            }, year, month, day)
            dpd.show()
        })

        nextStepButton.setOnClickListener(View.OnClickListener {
            val shopNameEdit=findViewById<EditText>(R.id.shop_name_edit)
            val localisationNameEdit=findViewById<EditText>(R.id.localisation_edit)

            val bundle=Bundle()
            bundle.putString("shop_name",shopNameEdit.text.toString())
            bundle.putString("localisation",localisationNameEdit.text.toString())
            bundle.putString("shopping_date",shoppingDate.text.toString())
            val intent= Intent(this,ShoppingListActivity::class.java)
            intent.putExtra("bundle",bundle)
            startActivity(intent)
        })
    }
}
