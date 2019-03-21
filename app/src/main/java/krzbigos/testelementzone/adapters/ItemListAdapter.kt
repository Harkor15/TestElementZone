package krzbigos.testelementzone.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import krzbigos.testelementzone.R
import krzbigos.testelementzone.interfaces.ItemsListDeleteInterface

class ItemListAdapter(val context: Context, val listItems:ArrayList<String>, val itemsListDeleteInterface: ItemsListDeleteInterface): BaseAdapter() {
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val listRow: View =layoutInflater.inflate(R.layout.list_item_row,viewGroup,false)
        listRow.findViewById<TextView>(R.id.item_product_text).text=listItems[position]
        val deleteButton=listRow.findViewById<ImageView>(R.id.delete_icon)
        deleteButton.setOnClickListener(View.OnClickListener {
            itemsListDeleteInterface.deleteItem(position)
        })
        return listRow
    }

    override fun getItem(position: Int): Any {
        return listItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listItems.size
    }

}