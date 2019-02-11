package com.example.love.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.example.love.Adapter.Intro_ImageAdapter
import com.example.love.R
import com.example.love.splash
import com.viewpagerindicator.CirclePageIndicator
import java.util.ArrayList

class Intropage : AppCompatActivity() {

    private var mPager: ViewPager? = null
    private var currentPage = 0
    private var NUM_PAGES = 0
    private var isLastPageSwiped: Boolean = false
    private var counterPageScroll: Int = 0
    private val IMAGES =
        arrayOf(
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
        )
    private val color = arrayOf(R.color.colorAccent,R.color.bg_screen2,R.color.bg_screen3)

    private val ImagesArray = ArrayList<Int>()
    private val colorArray = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intropage)
        supportActionBar!!.hide()
        //        ActionBar actionBar = getActionBar();
        //        actionBar.hide();
        init()
    }

    private fun init() {
        for (i in IMAGES.indices) {
            ImagesArray.add(IMAGES[i])
            colorArray.add(color[i])
        }
        mPager = findViewById(R.id.pager) as ViewPager


        mPager!!.adapter = Intro_ImageAdapter(this, ImagesArray,colorArray)


        val indicator = findViewById(R.id.indicator) as CirclePageIndicator

        indicator.setViewPager(mPager)

        val density = resources.displayMetrics.density

        //Set circle indicator radius
        indicator.setRadius(5 * density)

        NUM_PAGES = IMAGES.size


        // Pager listener over indicator
        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                currentPage = position

            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {
                Log.e("count", "onPageScrolled: $pos")
                if (pos == 2 && arg1 == 0f && !isLastPageSwiped) {
                    if (counterPageScroll != 0) {
                        isLastPageSwiped = true
                        startActivity(Intent(this@Intropage, splash::class.java))
                    }
                    counterPageScroll++
                } else {
                    counterPageScroll = 0
                }
            }

            override fun onPageScrollStateChanged(pos: Int) {

            }
        })

    }

}
