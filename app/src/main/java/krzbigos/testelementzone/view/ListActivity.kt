package krzbigos.testelementzone.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.ListView
import krzbigos.testelementzone.R
import krzbigos.testelementzone.adapters.ListViewCustomAdapter
import krzbigos.testelementzone.interfaces.CustomAdapterInterface
import krzbigos.testelementzone.model.SingleOrder
import krzbigos.testelementzone.services.ListViewDataGenerator
import krzbigos.testelementzone.services.SharedPrefKey
import kotlin.collections.ArrayList


class ListActivity : AppCompatActivity(), CustomAdapterInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val key= SharedPrefKey(applicationContext).getSharedPrefKey()
         ListViewDataGenerator().getListViewData(key,this)
        val addButton=findViewById<FloatingActionButton>(R.id.add_button)
        addButton.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,ShopDataActivity::class.java)
            startActivity(intent)
        })
    }

    override fun completeListView(listViewData: List<SingleOrder>) {
        val customAdapter=ListViewCustomAdapter(applicationContext, listViewData, this)
        findViewById<ListView>(R.id.list_view)
            .adapter= customAdapter
    }
    override fun openDetailsActivity(shopName: String,orderDate:String, orderPrice:String,
                                     items:ArrayList<String>,orderId: Int,location:String){
        val intent = Intent(this, OrderDetailsActivity::class.java)
        val bundle= Bundle()
        bundle.putInt("order_id",orderId)
        bundle.putString("shop_name",shopName)
        bundle.putString("order_date",orderDate)
        bundle.putString("order_price",orderPrice)
        bundle.putString("location",location)
        bundle.putStringArrayList("items",items)
        intent.putExtra("bundle",bundle)
        startActivity(intent)
    }
}

