package krzbigos.testelementzone.model

import java.util.*

class OrdersResponse(
    val data: List<SingleOrder>
)

class SingleOrder (
    val id: Int,
    val date: Date,
    val shop_name:String,
    val location: String,
    val price: Double,
    val items: List<OrderedItem>
)

class OrderedItem(
    val item: String
)

class OrdersData(
    val api_token: String,
    val offset: Int,
    val limit: Int
)