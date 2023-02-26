package nl.pdik.level6.task1.data.repository

import android.util.Log
import kotlinx.coroutines.withTimeout
import nl.pdik.level6.task1.data.api.Api
import nl.pdik.level6.task1.data.api.ApiService
import nl.pdik.level6.task1.data.api.util.Resource
import nl.pdik.level6.task1.data.model.Cat
import nl.pdik.level6.task1.data.model.Dog

class DogRepository {
    private val apiService: ApiService = Api.dogsClient;
    /**
     * suspend function that calls a suspend function from the apiService call
     * @return result wrapped in our own Resource sealed class
     */
    suspend fun getRandomDog(): Resource<Dog> {

        val response = try {
            withTimeout(5_000) {
                apiService.getRandomDog()
            }
        } catch (e: Exception) {
            Log.e("NumbersRepository", e.message ?: "No exception message available")
            return Resource.Error("An unknown error occured")
        }

        return Resource.Success(response)
    }
}

