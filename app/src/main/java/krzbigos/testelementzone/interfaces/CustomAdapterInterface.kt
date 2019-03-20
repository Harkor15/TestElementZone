package krzbigos.testelementzone.interfaces

import krzbigos.testelementzone.model.SingleOrder

interface CustomAdapterInterface {
    fun completeListView(listViewData: List<SingleOrder>)
    fun openDetailsActivity(shopName: String,orderDate:String, orderPrice:String,
                            items:ArrayList<String>,orderId: Int,location: String)
}