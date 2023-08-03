package com.azcryptoapp.data.remote

import com.azcryptoapp.data.remote.dto.CoinDetailDto
import com.azcryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoin(@Path("coinId") coinId: String):CoinDetailDto
}