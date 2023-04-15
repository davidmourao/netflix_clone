package com.dev_david.netflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.dev_david.netflixclone.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val videoUrl = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-9209e" +
                ".appspot.com/o/THE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX" +
                ".mp4?alt=media&token=823a2c90-44ae-4572-9399-02a1f89eca31")
        val video = binding.video
        video.setMediaController(MediaController(this))
        video.setVideoURI(videoUrl)
        video.requestFocus()
        video.start()

    }
}