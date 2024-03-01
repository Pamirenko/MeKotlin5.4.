import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mekotlin54.data.model.CharactersItems
import com.example.mekotlin54.data.repository.HarryCharacterRepository
import com.example.mekotlin54.utils.UiState


class CharacterViewModel : ViewModel() {
    private val characterRepository = HarryCharacterRepository()
    private val _characterLiveData = MutableLiveData<UiState<List<CharactersItems>>>()
    val characterLiveData: LiveData<UiState<List<CharactersItems>>> = _characterLiveData

    init {
        characterRepository.getCharacter(
            onResponse = { data ->
                Log.e("TAG", data.toString(), )
                _characterLiveData.value = UiState(isLoading = false, success = data)
            },
            onFailure = { t ->
                Log.e("TAG", t.message.toString(), )
                _characterLiveData.value =
                    UiState(isLoading = false, errorMessage = t.message ?: "error")

            }
        )
    }
}