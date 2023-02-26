package nl.pdik.level6.task1.ui.screens.cats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nl.pdik.level6.task1.data.api.util.Resource
import nl.pdik.level6.task1.data.model.Cat
import nl.pdik.level6.task1.data.repository.CatRepository

class CatsViewModel(application: Application) : AndroidViewModel(application) {
    private val catRepository = CatRepository()

    /**
     * Expose non MutableLiveData via getter
     * errorText can be observed from Activity for error showing
     * Encapsulation :)
     */
    val catResource: LiveData<Resource<Cat>>
        get() = _catResource

    //initialize it with an Empty type of Resource
    private val _catResource: MutableLiveData<Resource<Cat>> = MutableLiveData(Resource.Empty())

    /**
     * The viewModelScope is bound to Dispatchers.Main and will automatically be cancelled when the ViewModel is cleared.
     * Extension method of lifecycle-viewmodel-ktx library
     */
    fun getCat(numberType: String) {
        //set resource type to loading
        _catResource.value = Resource.Loading()

        viewModelScope.launch {
            _catResource.value = catRepository.getRandomCat();
        }
    }
}
