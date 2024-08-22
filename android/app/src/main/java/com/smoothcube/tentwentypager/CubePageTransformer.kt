package com.smoothcube.tentwentypager

import android.view.View
import androidx.viewpager.widget.ViewPager

class CubePageTransformer : ViewPager.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        val deltaY = 0.1F

        view.pivotX = if (position < 0F) view.width.toFloat() else 0F
        view.pivotY = view.height * deltaY
        view.rotationY = 45F * position
    }

}