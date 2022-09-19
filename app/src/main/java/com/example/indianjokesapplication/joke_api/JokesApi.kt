package com.example.indianjokesapplication.joke_api
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl("https://indian-jokes-api.herokuapp.com/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface GetJokesInterface{
    @GET("jokes")
    suspend fun getJokes() : List<JokeDataClassItem>
}

object JokesApi {
   val getJokes : GetJokesInterface by lazy {
       retrofit.create(GetJokesInterface::class.java)
   }

}
