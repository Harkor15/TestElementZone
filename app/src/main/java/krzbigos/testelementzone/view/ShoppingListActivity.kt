package krzbigos.testelementzone.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.*
import krzbigos.testelementzone.R
import krzbigos.testelementzone.adapters.ItemListAdapter
import krzbigos.testelementzone.interfaces.ItemsListDeleteInterface

class ShoppingListActivity : AppCompatActivity(),ItemsListDeleteInterface {
    var listItems = ArrayList<String>()
    var itemListAdapter= ItemListAdapter(this,listItems,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
        val bundle=intent.extras.getBundle("bundle")

        findViewById<ListView>(R.id.added_items_list).adapter=itemListAdapter
        val productEdit=findViewById<EditText>(R.id.product_edit)
        val done_button=findViewById<Button>(R.id.done_button)

        done_button.setOnClickListener(View.OnClickListener {


        })

        val addProductButton = findViewById<FloatingActionButton>(R.id.add_product_button)
        addProductButton.setOnClickListener(View.OnClickListener {
            addItem(productEdit.text.toString())
            productEdit.text.clear()
        })
    }

    override fun deleteItem(id: Int) {
        listItems.removeAt(id)
        itemListAdapter.notifyDataSetChanged()
    }

    fun addItem(item:String){
        listItems.add(item)
        itemListAdapter.notifyDataSetChanged()
    }

}


