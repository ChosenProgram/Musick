package com.kraykray.musick

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun NowPlayingUI(){
    Box(
        Modifier
            .animateContentSize()
            .fillMaxWidth()
            .height(if (e.expanded) 1000.dp else 100.dp)
            .padding(if (e.expanded) 0.dp else 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.surfaceContainer)

    ) {
        NowPlayExpansion(
            Modifier
                .padding(10.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    e.toggle()
                },
            e.expanded
        )
    }
}

@Composable
fun Player(){
    Box (
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainer)
    ){
        Box (
            Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
                .height(50.dp)

        ){
            Row(
                Modifier
                    .align(Alignment.CenterStart)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { e.toggle() },
            ) {
                Icon(
                    painterResource(R.drawable.collapse),
                    "Music Note Identity",
                    Modifier
                        .padding(10.dp),
                    tint = MaterialTheme.colorScheme.inverseSurface,
                )
            }
            Row(
                Modifier
                    .align(Alignment.CenterEnd)
            ) {
                Icon(
                    painterResource(R.drawable.more),
                    "Music Note Identity",
                    Modifier
                        .padding(10.dp),
                    tint = MaterialTheme.colorScheme.inverseSurface,
                )
            }
        }
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            Column (
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                AlbumArt()
                Text(
                    stringResource(R.string.song_title),
                    Modifier
                        .padding(top = 50.dp),
                    color = MaterialTheme.colorScheme.inverseSurface,
                    textAlign = TextAlign.Start
                )
                Controls()
            }
        }
    }
}

@Composable
fun AlbumArt(){
    Box (
        Modifier
            .size(350.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.surfaceContainerHigh),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painterResource(R.drawable.musick_note),
            "Music Note Identity",
            Modifier
                .size(100.dp)
                .alpha(0.7f),
            tint = MaterialTheme.colorScheme.inverseSurface
        )
    }
}

@Composable
fun Controls(){
    Column (
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 20.dp),
    ){
        var sliderPosition by remember { mutableFloatStateOf(0f) }
        Slider(
            value = sliderPosition,
            onValueChange = {sliderPosition = it},
            valueRange = 0f..1f,
            enabled = true
        )
    }
    Box(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Row (
            Modifier
                .fillMaxWidth(),
            Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painterResource(R.drawable.previous), null,
                tint = MaterialTheme.colorScheme.inverseSurface
            )
            PlaybackControl(
                Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        plpa.toggle()
                    },
                plpa.playback
            )
            Icon(
                painterResource(R.drawable.next), null,
                tint = MaterialTheme.colorScheme.inverseSurface
            )
        }
    }
}
