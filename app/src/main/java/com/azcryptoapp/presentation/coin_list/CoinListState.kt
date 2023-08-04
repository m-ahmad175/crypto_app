package com.azcryptoapp.presentation.coin_list

import com.azcryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val original: List<Coin> = emptyList(),
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)