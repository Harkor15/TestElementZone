package krzbigos.testelementzone.model

class LoginResponse(
    val data: LoginDataResponse
)

class LoginDataResponse(
    val api_token: String
)

class LoginData(
    val email:String,
    val password:String
)