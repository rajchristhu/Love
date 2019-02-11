package com.example.love.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.love.Fragment.buttonClick
import com.example.love.R


class EventActiviy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        val extras = intent.extras
        val arrayB = extras!!.getInt("numbers")
        if (arrayB == 0) {
            val intent = Intent(applicationContext, FlamesActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val fragment: Fragment = when (arrayB) {
                1 -> buttonClick()
                2 -> buttonClick()
                3 -> buttonClick()
                else -> buttonClick()
            }
            val fragmentManager = supportFragmentManager
            fragmentManager
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()
        }
    }
}
