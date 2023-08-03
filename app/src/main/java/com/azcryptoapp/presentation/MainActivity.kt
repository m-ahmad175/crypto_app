package com.azcryptoapp.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.azcryptoapp.ui.CryptoAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CryptoAppTheme(isDark = false) {

                Surface(color = MaterialTheme.colors.background) {


                }
            }
        }
    }
}