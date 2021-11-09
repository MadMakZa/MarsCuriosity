package makza.afonsky.marscuriosity.api

import makza.afonsky.marscuriosity.data.Photos
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("curiosity")
    fun getPhotoList(): Call<MutableList<Photos>>
}