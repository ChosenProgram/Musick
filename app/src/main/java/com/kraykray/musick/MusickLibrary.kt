package com.kraykray.musick

import android.content.ContentResolver
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.*

@Composable
fun ListUI(){
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ){
        MusickList()
    }
}

@Composable
fun MusickList(){
    val context = LocalContext.current
    val cr = context.contentResolver
    val mp3List = remember {
        musicDataRetrieval(cr)
    }

    LazyColumn {
        items(mp3List){song ->
            Listing(cr, song)
        }
    }
}

@Composable
fun Listing(cr: ContentResolver, list: TrackInfo){
    Box(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surface)
    ){
        Row (
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            val art = remember (list.id){albumArt(cr, list.id)}
            if(art != null){
                Image(
                        bitmap = art.asImageBitmap(),
                    "Album Art",
                        Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                } else {
                DefaultArt()
                }
            Column {
                Text(
                    list.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.inverseSurface
                )
                Text(
                    list.artist,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inverseSurface
                )
            }
        }
    }
}


