package com.example.love.Activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import org.apache.commons.lang3.ArrayUtils
import java.text.MessageFormat
import android.content.DialogInterface
import android.view.Gravity
import android.widget.LinearLayout
import android.graphics.Typeface
import android.util.TypedValue
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import com.example.love.R


class FlamesActivity : AppCompatActivity() {
    internal lateinit var layout_yourName: TextInputLayout
    internal lateinit var layout_partnerName: TextInputLayout
    internal lateinit var edit_yourName: TextInputEditText
    internal lateinit var edit_partnerName: TextInputEditText
    internal lateinit var btn_calculate: Button
    internal lateinit var text_flamesResult: TextView

    internal var FLAMES = "FLAMES"
    internal var arr_FLAMES = FLAMES.toCharArray()

    internal lateinit var yourName: String
    internal lateinit var yourNameDisplay: String
    internal lateinit var partnerName: String
    internal lateinit var partnerNameDisplay: String
    internal lateinit var completeName: String
    internal lateinit var arr_yourName: Array<String>
    internal lateinit var arr_partnerName: Array<String>
    internal lateinit var arr_completeName: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flames)

        layout_yourName = findViewById(R.id.input_layout_your_name) as TextInputLayout
        layout_partnerName = findViewById(R.id.input_layout_partner_name) as TextInputLayout

        edit_yourName = findViewById(R.id.input_your_name) as TextInputEditText
        edit_partnerName = findViewById(R.id.input_partner_name) as TextInputEditText

        btn_calculate = findViewById(R.id.button_calculate) as Button
        text_flamesResult = findViewById(R.id.text_flames_result) as TextView

        btn_calculate.setOnClickListener(View.OnClickListener {
            // Hide Soft Keyboard onClick
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                if (null == currentFocus) null else currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )




            resetValues()

            if (edit_yourName.text!!.toString().trim { it <= ' ' }.isEmpty()) return@OnClickListener
            if (edit_partnerName.text!!.toString().trim { it <= ' ' }.isEmpty()) return@OnClickListener

            processName()
            eliminateCommonLetters()
            flamesCalculator()
            displayFlames()
        })
    }

    fun resetValues() {
        FLAMES = getString(R.string.FLAMES)
        arr_FLAMES = FLAMES.toCharArray()
        text_flamesResult.text = ""
    }

    fun alert(ans:String) {
        val dialog = AlertDialog.Builder(this)
        val title = TextView(this)
        title.setTextColor(ContextCompat.getColor(this, android.R.color.black))
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        title.typeface = Typeface.DEFAULT_BOLD
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        lp.setMargins(0, 20, 0, 0)
        title.setPadding(0, 30, 0, 0)
        title.layoutParams = lp
        title.text = ans
        title.gravity = Gravity.CENTER
        dialog.setCustomTitle(title)
        dialog.setMessage("OMG")
        dialog.setCancelable(false)
        dialog.setPositiveButton("OK", { dialog, which -> })
        dialog.show()

    }

    fun processName() {
        yourNameDisplay = edit_yourName.text!!.toString()
        yourName = yourNameDisplay.toLowerCase().replace("\\s+".toRegex(), "")
        arr_yourName = yourName.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        partnerNameDisplay = edit_partnerName.text!!.toString()
        partnerName = partnerNameDisplay.toLowerCase().replace("\\s+".toRegex(), "")
        arr_partnerName = partnerName.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }

    fun eliminateCommonLetters() {
        for (i in arr_yourName) {
            for (j in arr_partnerName) {
                if (i == j) {
                    arr_yourName = ArrayUtils.removeElement(arr_yourName, i)
                    arr_partnerName = ArrayUtils.removeElement(arr_partnerName, j)
                    break
                }
            }
        }

        arr_completeName = ArrayUtils.addAll(arr_yourName, *arr_partnerName)
        val stringBuilder = StringBuilder()
        for (string in arr_completeName) {
            stringBuilder.append(string)
        }

        completeName = stringBuilder.toString()
    }

    fun flamesCalculator() {
        var index: Int
        var flamesLength = 6

        while (FLAMES.length != 1) {
            index = completeName.length % flamesLength

            if (index == 0) {
                FLAMES = FLAMES.replace(arr_FLAMES[FLAMES.length - 1].toString(), "")
                arr_FLAMES = FLAMES.toCharArray()
            } else {
                FLAMES = FLAMES.replace(arr_FLAMES[index - 1].toString(), "")
                FLAMES = FLAMES.substring(index - 1) + FLAMES.substring(0, index - 1)
                arr_FLAMES = FLAMES.toCharArray()
            }

            flamesLength--
        }

    }

    fun displayFlames() {

        text_flamesResult.visibility = View.VISIBLE
        when (arr_FLAMES[0]) {
            'F' -> alert("Friend")
            'L' -> alert("lovers!")
            'A' -> alert(
                "affectionate towards each other!"
            )
            'M' -> alert("married!")
            'E' -> alert("enemies!")
            'S' -> alert("like siblings!")
        }
    }
}