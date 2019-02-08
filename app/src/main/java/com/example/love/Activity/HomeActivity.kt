package com.example.love.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.example.love.Adapter.ViewpagerAdapter
import com.example.love.R


class HomeActivity : AppCompatActivity() {
    var viewPager: ViewPager? = null
    var images = intArrayOf(R.drawable.re, R.drawable.love, R.drawable.iuy, R.drawable.heart)
    var myCustomPagerAdapter: ViewpagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.love.R.layout.activity_home)
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        myCustomPagerAdapter = ViewpagerAdapter(this@HomeActivity, images)
        viewPager!!.adapter = myCustomPagerAdapter
    }
}
