package com.example.love.Activity

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.example.love.Fragment.Flames
import com.example.love.R
import kotlin.math.log


class EventActiviy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar()
        setContentView(R.layout.activity_event_activiy)
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
    private fun hideStatusBar(){
        if (Build.VERSION.SDK_INT >= 16) {
            getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
            getWindow().getDecorView().setSystemUiVisibility(3328);
        }else{
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}
