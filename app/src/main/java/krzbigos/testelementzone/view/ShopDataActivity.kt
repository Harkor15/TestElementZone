package krzbigos.testelementzone.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import krzbigos.testelementzone.R

class ShopDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_data)
        val nextStepButton=findViewById<Button>(R.id.next_step_button)
        nextStepButton.setOnClickListener(View.OnClickListener {
            val shopNameEdit=findViewById<EditText>(R.id.shop_name_edit)
            val localisationNameEdit=findViewById<EditText>(R.id.localisation_edit)
            val shoppingListEdit=findViewById<EditText>(R.id.shopping_list_edit)
            val bundle=Bundle()
            bundle.putString("shop_name",shopNameEdit.text.toString())
            bundle.putString("localisation",localisationNameEdit.text.toString())
            bundle.putString("shopping_list",shoppingListEdit.text.toString())
            val intent= Intent(this,ShoppingListActivity::class.java)
            intent.putExtra("bundle",bundle)
            startActivity(intent)
        })
    }
}
