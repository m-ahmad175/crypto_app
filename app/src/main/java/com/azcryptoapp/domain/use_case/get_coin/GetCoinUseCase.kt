package com.azcryptoapp.domain.use_case.get_coin

import com.azcryptoapp.common.Resource
import com.azcryptoapp.data.remote.dto.toCoinDetail
import com.azcryptoapp.domain.model.CoinDetail
import com.azcryptoapp.domain.reposotory.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading())
            val coin = coinRepository.getCoin(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error"))
        }
    }
}