package com.azcryptoapp.presentation.coin_detail

import com.azcryptoapp.domain.model.Coin
import com.azcryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)