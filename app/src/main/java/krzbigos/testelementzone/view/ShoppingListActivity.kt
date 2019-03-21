package krzbigos.testelementzone.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_shopping_list.*
import krzbigos.testelementzone.R
import krzbigos.testelementzone.adapters.ItemListAdapter
import krzbigos.testelementzone.interfaces.ItemsListDeleteInterface
import krzbigos.testelementzone.interfaces.ShopingListInterface
import krzbigos.testelementzone.model.AddOrderData
import krzbigos.testelementzone.services.AddOrder
import krzbigos.testelementzone.services.SharedPrefKey

class ShoppingListActivity : AppCompatActivity(),ItemsListDeleteInterface,ShopingListInterface {


    var listItems = ArrayList<String>()
    var itemListAdapter= ItemListAdapter(this,listItems,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
        val bundle=intent.extras.getBundle("bundle")

        findViewById<ListView>(R.id.added_items_list).adapter=itemListAdapter
        val productEdit=findViewById<EditText>(R.id.product_edit)
        val done_button=findViewById<Button>(R.id.done_button)
        val amountEdit=findViewById<EditText>(R.id.amount_edit)
        done_button.setOnClickListener(View.OnClickListener {
            val sharedPrefKey=SharedPrefKey(applicationContext)
            val itemsListArray=listItems.toTypedArray()
            val amount: Float
            if(amountEdit.text.isEmpty()){
                amount="0".toFloat()
            }else{
                amount=amountEdit.text.toString().toFloat()
            }

            val addOrderData=AddOrderData(sharedPrefKey.getSharedPrefKey(),bundle.getString("shopping_date"),
                bundle.getString("shop_name"),bundle.getString("localisation"),amount,itemsListArray)
            AddOrder().addOrder(addOrderData,this)
        })

        val addProductButton = findViewById<FloatingActionButton>(R.id.add_product_button)
        addProductButton.setOnClickListener(View.OnClickListener {
            addItem(productEdit.text.toString())
            productEdit.text.clear()
        })
    }
    override fun openMenu() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
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


