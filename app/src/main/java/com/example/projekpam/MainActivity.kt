package com.example.projekpam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.projekpam.navigation.AppNavHost
import com.example.projekpam.ui.theme.AkademikTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AkademikTheme {
                AppNavHost()
            }
        }
    }
}