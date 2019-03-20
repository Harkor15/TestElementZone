package krzbigos.testelementzone.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import krzbigos.testelementzone.R
import krzbigos.testelementzone.model.SingleOrder
import java.text.SimpleDateFormat


class ListViewCustomAdapter(context: Context,listData:List<SingleOrder>): BaseAdapter(){
    private val mContext: Context
    private val mListData: List<SingleOrder>
    init {
        mListData=listData
        mContext=context
    }

    override fun getCount(): Int {
        return 8
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return "item $position"
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

        val layoutInflater= LayoutInflater.from(mContext)
        val listRow=layoutInflater.inflate(R.layout.list_row,viewGroup,false)

        val shopName=listRow.findViewById<TextView>(R.id.shop_name_text)
        shopName.text=mListData.get(position).shop_name

        val dateText=listRow.findViewById<TextView>(R.id.date_text)
        val format:SimpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        val date=mListData.get(position).date
        dateText.text=format.format(date)

        listRow.setOnClickListener(View.OnClickListener {




        })
        return listRow
    }

}