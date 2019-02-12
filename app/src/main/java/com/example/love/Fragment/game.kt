package com.example.love.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.dialog.view.*
import kotlinx.android.synthetic.main.menudialog.view.*
import android.view.MotionEvent
import android.view.View.OnTouchListener
import com.example.love.R
import kotlinx.android.synthetic.main.menudialog.*


class game : Fragment() {
    companion object {

        fun newInstance(): game {
            return game()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_game, container, false)
        alert()


        return v
    }

    fun alert() {
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.menudialog, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(context!!)
            .setView(mDialogView)
            .setIcon(R.drawable.cc)
            .setTitle("Choose")
        mBuilder.setCancelable(false)
        //show dialog
        val mAlertDialog = mBuilder.show()
        mDialogView.male.setOnClickListener {
            mDialogView.lin.visibility = View.VISIBLE
            mDialogView.male.setBackgroundResource(R.drawable.cann)
            mDialogView.female.setBackgroundResource(R.drawable.cc)
        }
        mDialogView.female.setOnClickListener {
            mDialogView.lin.visibility = View.VISIBLE
            mDialogView.male.setBackgroundResource(R.drawable.cc)
            mDialogView.female.setBackgroundResource(R.drawable.cann)
        }
        //login button click of custom layout
        //cancel button click of custom layout
        mDialogView.can.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
            alert1()
        }
    }

    fun alert1() {
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.catdialog, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(context!!)
            .setView(mDialogView)
            .setIcon(R.drawable.cc)
            .setTitle("Choose")
        mBuilder.setCancelable(false)
        //show dialog
        val mAlertDialog = mBuilder.show()
        //login button click of custom layout
        //cancel button click of custom layout
        mDialogView.can.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
        }
    }
}
