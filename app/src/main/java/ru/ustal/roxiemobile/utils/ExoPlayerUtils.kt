package ru.ustal.roxiemobile.utils

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

fun SimpleExoPlayer.prepareExoPlayerMediaSource(url: String, context: Context): SimpleExoPlayer {
    val mediaItem = MediaItem.fromUri(Uri.parse(url))
    val dataSourceFactory = DefaultDataSourceFactory(context, Util.getUserAgent(context, "Roxi"))
    val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
    setMediaSource(mediaSource)
    prepare()
    return this
}