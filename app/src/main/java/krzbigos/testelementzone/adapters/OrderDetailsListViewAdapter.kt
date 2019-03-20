package krzbigos.testelementzone.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import krzbigos.testelementzone.R

class OrderDetailsListViewCustomAdapter(context: Context, items: ArrayList<String>): BaseAdapter(){
    private val mItems: ArrayList<String>
    private val mContext: Context
    init{
        mContext=context
        mItems=items
    }

    override fun getView(position: Int, p1: View?, viewGroup: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mContext)
        val listRow: View =layoutInflater.inflate(R.layout.order_details_row,viewGroup,false)
        val itemTex =listRow.findViewById<TextView>(R.id.item_text)
        itemTex.text=mItems[position]
        return listRow
    }

    override fun getItem(position: Int): Any {
        return mItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mItems.size
    }

}