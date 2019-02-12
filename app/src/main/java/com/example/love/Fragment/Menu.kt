package com.example.love.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.love.R


class Menu : Fragment() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        var single: CardView? = null

        fun newInstance(): Menu {
            return Menu()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_menu, container, false)
        single = v.findViewById<CardView>(R.id.cv)
        single!!.setOnClickListener {
            val fragment2 = game()
            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.frame, fragment2)
            fragmentTransaction.commit()
        }


        return v
    }
}
