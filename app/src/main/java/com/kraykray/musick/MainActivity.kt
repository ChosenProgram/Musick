package com.kraykray.musick

import android.os.Bundle
import androidx.activity.*
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kraykray.musick.ui.theme.MusickTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusickTheme {
                KrayKrayUI()
            }
        }
    }
}

@Preview
@Composable
fun KrayPrev(){
    KrayKrayUI()
}

@Preview
@Composable
fun NowPlay(){
    Player()
}

@Preview
@Composable
fun List(){
    ListUI()
}


@Preview
@Composable
fun ML(){
    MusickList()
}