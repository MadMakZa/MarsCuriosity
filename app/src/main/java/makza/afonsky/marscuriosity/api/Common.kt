package makza.afonsky.marscuriosity.api

object Common {
    private val KEY_API = "gfwHlBq7JmrIUhXPk4mXkC7QczagsUjeIpWKIRzc"
    private val BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/"

    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}