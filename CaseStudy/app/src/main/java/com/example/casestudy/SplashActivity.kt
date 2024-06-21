package com.example.casestudy

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.casestudy.tanitim.GirisActivity
import com.example.casestudy.tanitim.Tanitim1Activity

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE)
        val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)

        Handler().postDelayed({
            if (isFirstRun) {
                val intent = Intent(this@SplashActivity, Tanitim1Activity::class.java)
                startActivity(intent)
                sharedPreferences.edit().putBoolean("isFirstRun", false).apply()
            } else {
                val intent = Intent(this@SplashActivity, GirisActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, splashTimeOut)
    }
}
