package com.example.memesapp.FirstScreen.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memesapp.FirstScreen.Data.remote.MemesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FirstScreenViewModel @Inject constructor(private val memesRepository: MemesRepository):ViewModel(){





    private  val _state= MutableStateFlow(FirstScreenState())
    val state= _state.asStateFlow()

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init {

        viewModelScope.launch {
            memesRepository.getAllMemesList().collectLatest {result->

                when(result)
                {
//                    is Result.Error -> {
//                        _showErrorToastChannel.send(true)
//                    }
//                    is Result.Success ->{
//                        result.data?.let{products->
//
//                            _state.update {
//                                it.copy(
//                                    memesList = products
//                                )
//                            }
//                           // _products.update { products }
//
//                        }
//                    }

                    is com.example.memesapp.FirstScreen.Data.remote.Result.Error ->{
                        _showErrorToastChannel.send(true)
                    }
                    is com.example.memesapp.FirstScreen.Data.remote.Result.Success ->{
                        result.data?.let{products->

                            _state.update {
                                it.copy(
                                    memesList = products
                                )
                            }
                            // _products.update { products }

                        }
                    }
                }

            }
        }
    }

    fun event(e:FirstScreenEvent)
    {
        when(e)
        {
            FirstScreenEvent.memeClicked -> TODO()
            is FirstScreenEvent.querychanged -> TODO()
        }

    }
}