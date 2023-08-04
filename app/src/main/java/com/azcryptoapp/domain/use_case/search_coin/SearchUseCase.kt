package com.azcryptoapp.domain.use_case.search_coin

import com.azcryptoapp.domain.model.Coin
import java.util.*
import javax.inject.Inject

class SearchUseCase @Inject constructor() {


    fun getSearchedList(coins: List<Coin>, query: String): List<Coin> {

        val queryList: MutableList<Coin> = mutableListOf()

        coins.forEach { coin ->

            if (coin.name.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))) {
                queryList.add(coin)
            }
        }
        return queryList
    }
}