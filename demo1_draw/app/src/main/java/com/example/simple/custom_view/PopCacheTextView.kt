package com.example.simple.custom_view

import android.content.Context
import android.os.Looper
import android.util.AttributeSet
import android.view.View

/**
 *
 *   Created by kingshingyeh on 2020/1/22.
 */

class PopCacheTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {

    private var listener: GoneListener? = null
    private var overSecondTime: Long = 2000L

    private var isFreeOverTime = false
        set(value) {
            field = value
            this.visibility = if (value) {
                listener?.viewGone(this)
                View.GONE
            } else View.VISIBLE
        }

    private val mHandler = android.os.Handler(Looper.getMainLooper())
    private var mRunnable = Runnable { isFreeOverTime = true }

    init {
        this.visibility = View.GONE
    }

    fun setOverTime(mm: Long) {
        this.overSecondTime = mm
    }

    fun setGoneListener(listener: GoneListener) {
        this.listener = listener
    }

    fun update(str: String) {
        isFreeOverTime = false
        this.text = str
        mHandler.removeCallbacks(mRunnable)
        mRunnable = Runnable { isFreeOverTime = true }
        mHandler.postDelayed(mRunnable, overSecondTime)
    }

    interface GoneListener {
        fun viewGone(view: PopCacheTextView)
    }
}