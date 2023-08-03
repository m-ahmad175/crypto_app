package com.azcryptoapp.domain.model

// that is the actual class data we need not the Dto one
// we map Dto class to the class we wanted to use
data class Coin(

    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
