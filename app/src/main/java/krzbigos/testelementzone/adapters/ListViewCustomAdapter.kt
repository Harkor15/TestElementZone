package krzbigos.testelementzone.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import krzbigos.testelementzone.R
import krzbigos.testelementzone.interfaces.CustomAdapterInterface
import krzbigos.testelementzone.model.SingleOrder
import java.text.SimpleDateFormat


class ListViewCustomAdapter(context: Context,listData:List<SingleOrder>,customAdapterInterface: CustomAdapterInterface): BaseAdapter(){
    private val mContext: Context
    private val mListData: List<SingleOrder>
    val mCustomAdapterInterface: CustomAdapterInterface
    init {
        mListData=listData
        mContext=context
        mCustomAdapterInterface=customAdapterInterface
    }

    override fun getCount(): Int {
        return mListData.size
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
            val arrayList=ArrayList<String>()
            for (i in 0 until  mListData[position].items.size) {
                arrayList.add(mListData[position].items[0].item)
            }

            mCustomAdapterInterface.openDetailsActivity(
                mListData[position].shop_name,
                format.format(date),
                mListData[position].price.toString(),
                arrayList,
                mListData[position].id,
                mListData[position].location
            )

        })
        return listRow
    }

}