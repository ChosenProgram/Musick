package com.kraykray.musick

import android.content.ContentResolver
import android.content.ContentUris
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import java.net.URI

class Collapse : ViewModel(){
    var expanded by mutableStateOf(false)

    fun toggle(){
        expanded = !expanded
    }
}
val e = Collapse()

class PLPA : ViewModel(){
    var playback by mutableStateOf(false)

    fun toggle(){
        playback = !playback
    }
}
val plpa = PLPA()


fun musicDataRetrieval(
    cr : ContentResolver
): List<TrackInfo>{
    val mp3List = mutableListOf<TrackInfo>()

    val storageAccess = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
        MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
    } else {
        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
    }

    val visualRepresentation = arrayOf(
        MediaStore.Audio.Media._ID,
        MediaStore.Audio.Media.TITLE,
        MediaStore.Audio.Media.ARTIST,
        MediaStore.Audio.Media.ALBUM,
        MediaStore.Audio.Media.DURATION
    )
    val sorting = "${MediaStore.Audio.Media.TITLE} ASC"

    cr.query(
        storageAccess,
        visualRepresentation,
        null,
        null,
        sorting
    )?.use{cursor ->
        while (cursor.moveToNext()){
            val id = cursor.getLong(
                cursor.getColumnIndexOrThrow(
                    MediaStore.Audio.Media._ID
                )
            )
            val title = cursor.getString(
                cursor.getColumnIndexOrThrow(
                    MediaStore.Audio.Media.TITLE
                )
            )
            val artist = cursor.getString(
                cursor.getColumnIndexOrThrow(
                    MediaStore.Audio.Media.ARTIST
                )
            )
            val album = cursor.getString(
                cursor.getColumnIndexOrThrow(
                    MediaStore.Audio.Media.ALBUM
                )
            )
            val duration = cursor.getLong(
                cursor.getColumnIndexOrThrow(
                    MediaStore.Audio.Media.DURATION
                )
            )
            val contentUri = ContentUris.withAppendedId(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                id
            )
            mp3List.add(TrackInfo(id, title, artist, album, duration, contentUri))
        }
    }
    return mp3List
}

fun albumArt(
    cr: ContentResolver,
    songId : Long,
): Bitmap?{
    val artUri = ContentUris.withAppendedId(
        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
        songId
    )

    return try {
        cr.openFileDescriptor(
            artUri, "r"
        )?.use {
            BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
        }
    } catch (e : Exception){
       Log.e("Album Art", "Error", e)
        null
    }
}

@Composable
fun DefaultArt(){
    Box (
        Modifier
            .size(50.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.surfaceContainerHigh),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painterResource(R.drawable.musick_note),
            "Music Note Identity",
            Modifier
                .size(30.dp)
                .alpha(0.6f),
            tint = MaterialTheme.colorScheme.inverseSurface
        )
    }
}