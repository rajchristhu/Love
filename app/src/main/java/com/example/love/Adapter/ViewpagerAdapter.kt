package com.example.love.Adapter

import android.widget.LinearLayout
import android.view.ViewGroup
import android.widget.Toast
import android.content.Context
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import android.widget.ImageView
import android.content.Intent


import com.example.love.Activity.EventActiviy
import com.example.love.R


class ViewpagerAdapter(internal var context: Context, internal var images: IntArray) : PagerAdapter() {
    internal var layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }



    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = layoutInflater.inflate(R.layout.items, container, false)
        val imageView = itemView.findViewById(R.id.imageView) as ImageView

        imageView.setImageResource(images[position])

        container.addView(itemView)



        //listening to image click
        imageView.setOnClickListener {
                val i = Intent(context, EventActiviy::class.java)
                i.putExtra("numbers", position)
                context.startActivity(i)
        }

        return itemView
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}