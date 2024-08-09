package com.kraykray.musick

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

val mods = Modifier
    .size(25.dp)
    .clip(RoundedCornerShape(100.dp))

@Composable
fun PlayerIdentity(){
    Box(
        mods
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painterResource(R.drawable.musick_note),
            "Music Note Identity",
            tint = MaterialTheme.colorScheme.inverseSurface
        )
    }
}

@Composable
fun UserProf(){
    Box (
        mods
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painterResource(R.drawable.user),
            "Music Note Identity",
            tint = MaterialTheme.colorScheme.inverseSurface
        )
    }
}

@Composable
fun Search(){
    Box (
        mods,
        contentAlignment = Alignment.Center
    ){
        Icon(
            painterResource(R.drawable.search),
            "Search Function",
            tint = MaterialTheme.colorScheme.inverseSurface
        )
    }
}

@Composable
fun NotificationChannel(){
    Box (
        mods,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painterResource(R.drawable.notification),
            "In - App Notifications",
            tint = MaterialTheme.colorScheme.inverseSurface
        )
    }
}

@Composable
fun NowPlayExpansion(
    modifier : Modifier,
    expanded : Boolean
){
    AnimatedVisibility(
        expanded,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Player()
    }
    AnimatedVisibility(
        !expanded,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box (
            modifier
                .size(20.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painterResource(R.drawable.expands),
                null,
                tint = MaterialTheme.colorScheme.inverseSurface
            )
        }
    }
}

@Composable
fun PlaybackControl(
    modifier  : Modifier,
    plpa : Boolean
){
    if(plpa) {
        Box(
            modifier
        ) {
            Icon(
                painterResource(R.drawable.pause),
                null,
                Modifier
                    .size(30.dp)
                    .align(Alignment.Center),
                tint = MaterialTheme.colorScheme.inverseSurface
            )
        }
    } else {
        Box (
            modifier
        ){
            Icon(
                painterResource(R.drawable.play),
                null,
                Modifier
                    .size(30.dp)
                    .align(Alignment.Center),
                tint = MaterialTheme.colorScheme.inverseSurface
            )
        }
    }
}