package com.robybp.hearthstonehelper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.robybp.hearthstonehelper.ui.main.MainScreen
import com.robybp.hearthstonehelper.ui.theme.HearthstoneHelperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HearthstoneHelperTheme {
                MainScreen()
            }
        }
    }
}
