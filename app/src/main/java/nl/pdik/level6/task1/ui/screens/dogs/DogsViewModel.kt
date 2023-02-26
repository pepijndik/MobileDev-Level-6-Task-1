package nl.pdik.level6.task1.ui.screens.dogs

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nl.pdik.level6.task1.data.api.util.Resource
import nl.pdik.level6.task1.data.model.Cat
import nl.pdik.level6.task1.data.model.Dog
import nl.pdik.level6.task1.data.repository.CatRepository
import nl.pdik.level6.task1.data.repository.DogRepository

class DogsViewModel(application: Application) : AndroidViewModel(application) {
    private val dogRepository = DogRepository()

    /**
     * Expose non MutableLiveData via getter
     * errorText can be observed from Activity for error showing
     * Encapsulation :)
     */
    val catResource: LiveData<Resource<Dog>>
        get() = _dogResource

    //initialize it with an Empty type of Resource
    private val _dogResource: MutableLiveData<Resource<Dog>> = MutableLiveData(Resource.Empty())

    /**
     * The viewModelScope is bound to Dispatchers.Main and will automatically be cancelled when the ViewModel is cleared.
     * Extension method of lifecycle-viewmodel-ktx library
     */
    fun getDog(numberType: String) {
        //set resource type to loading
        _dogResource.value = Resource.Loading()

        viewModelScope.launch {
            _dogResource.value = dogRepository.getRandomDog()
        }
    }
}
