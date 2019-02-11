package com.example.love.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.love.R


class buttonClick : Fragment() {
    var click: Button? = null
    var checkpoint = 0
    var count: TextView? = null
    var sec: TextView? = null

    companion object {

        fun newInstance(): buttonClick {
            return buttonClick()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_button_click, container, false)
        click = v.findViewById(R.id.click)
        count = v.findViewById(R.id.count)
        sec = v.findViewById(R.id.sec)

        click()
        return v
    }

    private fun click() {
        click!!.setOnClickListener {
            checkpoint += 1
            count!!.text = (checkpoint.toString())

        }
        object : CountDownTimer(20000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

                sec!!.text = ("seconds remaining: " + millisUntilFinished / 1000)

            }

            override fun onFinish() {
                click!!.isEnabled = false
                sec!!.text = ("done!")
                sendMessage(checkpoint.toString())
            }

        }.start()
    }

    private fun sendMessage(toString: String) {
        Log.e("Raj", toString)
    }


}