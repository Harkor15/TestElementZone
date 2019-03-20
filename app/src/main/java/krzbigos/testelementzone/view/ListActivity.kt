package krzbigos.testelementzone.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import krzbigos.testelementzone.R
import krzbigos.testelementzone.interfaces.CustomAdapterInterface
import krzbigos.testelementzone.model.SingleOrder
import krzbigos.testelementzone.services.ListViewDataGenerator
import krzbigos.testelementzone.services.SharedPrefKey

class ListActivity : AppCompatActivity(), CustomAdapterInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val key= SharedPrefKey(applicationContext).getSharedPrefKey()
         ListViewDataGenerator().getListViewData(key,this)
    }

    override fun completeListView(listViewData: List<SingleOrder>) {
        findViewById<ListView>(R.id.list_view)
            .adapter=ListViewCustomAdapter(applicationContext,listViewData)
    }
}

