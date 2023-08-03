package com.azcryptoapp.data.repository

import com.azcryptoapp.data.remote.CoinPaprikaAPI
import com.azcryptoapp.data.remote.dto.CoinDetailDto
import com.azcryptoapp.data.remote.dto.CoinDto
import com.azcryptoapp.domain.reposotory.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val api: CoinPaprikaAPI
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {
        return api.getCoin(coinId)
    }

}