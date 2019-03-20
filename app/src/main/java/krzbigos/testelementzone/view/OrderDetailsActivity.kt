package krzbigos.testelementzone.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import krzbigos.testelementzone.R
import krzbigos.testelementzone.adapters.OrderDetailsListViewCustomAdapter
import krzbigos.testelementzone.interfaces.OrderDetailsSendLinkInterface
import krzbigos.testelementzone.services.InviteLink
import krzbigos.testelementzone.services.SharedPrefKey


class OrderDetailsActivity : AppCompatActivity(),OrderDetailsSendLinkInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        val bundle =intent.extras.getBundle("bundle")
        findViewById<TextView>(R.id.shop_name_text).text=bundle.getString("shop_name")
        findViewById<TextView>(R.id.date_text).text=bundle.getString("order_date")
        findViewById<TextView>(R.id.address_text).text=bundle.getString("location")
        val price=bundle.getString("order_price")
        findViewById<TextView>(R.id.money_text).text="$price  zł"
        val itemsListView=findViewById<ListView>(R.id.itemsListView)

        val itemsArrayList= bundle.getStringArrayList("items")
        itemsListView.adapter= OrderDetailsListViewCustomAdapter(applicationContext,itemsArrayList)
        val orderId=bundle.getInt("order_id")

        val inviteButton=findViewById<Button>(R.id.invite_button)
        inviteButton.setOnClickListener(View.OnClickListener {
            val inviteLink=InviteLink()
            val sharedPrefKey=SharedPrefKey(applicationContext)
            inviteLink.generateLinkToSend(this,orderId,sharedPrefKey.getSharedPrefKey())
        })

    }
    override fun sendLink(link: String){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,link )
            type = "text/plain"
        }
        startActivity(sendIntent)
    }
}
