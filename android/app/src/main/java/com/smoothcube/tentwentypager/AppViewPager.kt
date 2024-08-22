package com.smoothcube.tentwentypager

import android.content.Context
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class AppViewPager(context: Context) : ViewPager(context) {

    private var enabled: Boolean = true

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (enabled) {
            super.onTouchEvent(event)
        } else {
            false
        }
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (enabled) {
            super.onInterceptTouchEvent(event)
        } else {
            false
        }
    }

    fun setPagingEnabled(enabled: Boolean) {
        this.enabled = enabled
    }
}
