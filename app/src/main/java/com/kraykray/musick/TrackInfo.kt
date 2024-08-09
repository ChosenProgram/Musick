package com.kraykray.musick

import android.graphics.Bitmap
import android.net.Uri

data class TrackInfo(
    val id : Long,
    val title : String,
    val artist : String,
    val album : String,
    val duration : Long,
    val contentUri : Uri,
    val albumArt : Bitmap? = null
)
