package com.azcryptoapp.domain.reposotory

import com.azcryptoapp.data.remote.dto.CoinDetailDto
import com.azcryptoapp.data.remote.dto.CoinDto

// here it have only definition
interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoin(coinId:String):CoinDetailDto
}