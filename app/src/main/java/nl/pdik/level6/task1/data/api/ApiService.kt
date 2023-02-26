package nl.pdik.level6.task1.data.api

import nl.pdik.level6.task1.data.model.Cat
import nl.pdik.level6.task1.data.model.Dog
import retrofit2.http.GET

interface ApiService {
    @GET("/cat?json=true")
    suspend fun getRandomCat(): Cat

    @GET("/api/breeds/image/random")
    suspend fun getRandomDog(): Dog
}