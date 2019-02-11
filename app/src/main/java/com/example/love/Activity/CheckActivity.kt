package com.example.love.Activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.love.R
import com.example.love.splash

class CheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)
        val isFirstRun = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
            .getBoolean("isFirstRun", true)

        if (isFirstRun) run {
            //show start activity

            val intent = Intent(this, Intropage::class.java)
            startActivity(intent)
            finish()
        }

        else{
            val intent = Intent(this, splash::class.java)
            startActivity(intent)
            finish()
        }
        getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
            .putBoolean("isFirstRun", false).apply()
    }

}
