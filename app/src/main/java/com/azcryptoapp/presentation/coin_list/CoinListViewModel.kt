package com.azcryptoapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azcryptoapp.common.Resource
import com.azcryptoapp.domain.use_case.get_coins.GetCoinsUseCase
import com.azcryptoapp.domain.use_case.search_coin.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    val query = mutableStateOf("")
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {

        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(
                        coins = result.data ?: emptyList(),
                        original = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {

                    _state.value = CoinListState(error = result.message!!)
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onQueryChange(query: String) {
        this.query.value = query
        if (query == ""){

            val coins = _state.value.original
            _state.value = CoinListState(
                coins = coins ?: emptyList(),original = coins
            )
            return
        }

        if (state.value.original != null && state.value.original.isNotEmpty()) {

            val coins = searchUseCase.getSearchedList(state.value.original, query)
            _state.value = CoinListState(
                coins = coins ?: emptyList(), original = _state.value.original
            )
        }

    }
}