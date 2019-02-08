package com.example.love.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.love.Fragment.Flames
import com.example.love.R


class EventActiviy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        val extras = intent.extras
        val arrayB = extras!!.getInt("numbers")
        val fragment: Fragment = when (arrayB) {
            0 -> Flames()
            1 -> Flames()
            2 -> Flames()
            3 -> Flames()
            else -> Flames()
        }
        val fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }
}
