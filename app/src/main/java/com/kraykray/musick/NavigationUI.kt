package com.kraykray.musick

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NavigationUI(){
    Box(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(MaterialTheme.colorScheme.surfaceContainer),
        contentAlignment = Alignment.Center
    ) {
        Row (
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
        ){
            Icon(
                painterResource(R.drawable.home),
                null,
                Modifier.size(27.dp),
                tint = MaterialTheme.colorScheme.inverseSurface,
            )
            Icon(
                painterResource(R.drawable.library),
                null,
                Modifier
                    .size(24.dp)
                    .clickable(
                        remember { MutableInteractionSource() },
                        null
                    ) {

                    },
                tint = MaterialTheme.colorScheme.inverseSurface,
            )
        }
    }
}
