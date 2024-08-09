package com.kraykray.musick


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp

@Composable
fun KrayKrayUI(){
    Box (
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ){
        Column{
            Head()
        }
    }
    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            ListUI()
            NowPlayingUI()
            NavigationUI()
        }
    }
}

@Composable
fun Head(){
    Box (
        Modifier
            .fillMaxWidth()
            .height(70.dp)
    ){
        Row (
            Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            PlayerIdentity()
            Text(
                "Musick",
                color = MaterialTheme.colorScheme.inverseSurface
            )
        }
        Row (
            Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            NotificationChannel()
            Search()
            UserProf()
        }
    }
}

