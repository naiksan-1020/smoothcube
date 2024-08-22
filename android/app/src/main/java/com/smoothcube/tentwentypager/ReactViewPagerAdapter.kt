package com.smoothcube.tentwentypager

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class ReactViewPagerAdapter : PagerAdapter() {

    private val views = mutableListOf<View>()

    fun addView(view: View) {
        views.add(view)
        refreshViewChildrenLayout(view)
        notifyDataSetChanged()
    }

    fun removeView(view: View) {
        views.remove(view)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return views.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = views[position]
  
        if (view.parent === null){
        container.addView(view)
        refreshViewChildrenLayout(container)
      }

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    private fun refreshViewChildrenLayout(view: View) {
        view.post {
            view.measure(
                View.MeasureSpec.makeMeasureSpec(view.width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(view.height, View.MeasureSpec.EXACTLY))
            view.layout(view.left, view.top, view.right, view.bottom)
        }
    }
}
