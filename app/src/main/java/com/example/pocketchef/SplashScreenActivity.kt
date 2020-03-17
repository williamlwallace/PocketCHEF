package com.example.pocketchef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val titleLogo = findViewById<ImageView>(R.id.logo)

        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                    val intent = Intent(baseContext, MainActivity::class.java)
//                    val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this@SplashScreenActivity, titleLogo, "logo")
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

}


