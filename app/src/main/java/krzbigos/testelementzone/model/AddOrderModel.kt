package krzbigos.testelementzone.model


class AddOrderResponse{}

class AddOrderData(
    val api_token: String,
    val date:String,
    val shop_name:String,
    val location:String,
    val price:Float,
    val items:Array<String>
)