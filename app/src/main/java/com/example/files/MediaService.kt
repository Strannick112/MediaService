package com.example.files

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MediaService : Service() {
    var myAudioPlayer: MediaPlayer? = null

    override fun onCreate(){
        myAudioPlayer = MediaPlayer.create(this, R.raw.ourmusic)
    }

    override fun onBind(p0: Intent?): IBinder? {
        throw(Exception("meaw"))
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        myAudioPlayer?.start()
        return START_STICKY
    }

    override fun onDestroy() {
        myAudioPlayer?.stop()
        super.onDestroy()
    }
}