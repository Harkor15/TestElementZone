package krzbigos.testelementzone.model

class GenerateResponse(
    val data: GenerateSingle
)
class GenerateSingle(
    val link: String
)

class GenerateData(
    val api_token: String,
    val id: String
)