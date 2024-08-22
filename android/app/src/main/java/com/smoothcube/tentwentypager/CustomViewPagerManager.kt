package com.smoothcube.tentwentypager

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.modules.core.DeviceEventManagerModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager


class CustomViewPagerManager : ViewGroupManager<ViewPager>() {

    companion object {
        const val REACT_CLASS = "CustomViewPager"
    }

    private lateinit var adapter: ReactViewPagerAdapter
    private lateinit var viewPager: AppViewPager

    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(reactContext: ThemedReactContext): ViewPager {
        viewPager = AppViewPager(reactContext)
        viewPager.offscreenPageLimit = 5
        adapter = ReactViewPagerAdapter()
        viewPager.adapter = adapter
        viewPager.setPageTransformer(true, CubePageTransformer())
        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                reactContext
                    .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
                    .emit("pageChange", position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
        viewPager.setPagingEnabled(false)
        return viewPager
    }

    override fun addView(parent: ViewPager, child: View, index: Int) {
        adapter.addView(child)
        parent.adapter?.notifyDataSetChanged()
    }

    override fun removeViewAt(parent: ViewPager, index: Int) {
        val view = adapter.instantiateItem(parent, index) as View
        adapter.removeView(view)
        parent.adapter?.notifyDataSetChanged()
    }

    override fun getChildCount(parent: ViewPager): Int {
        return adapter.count
    }

    override fun getChildAt(parent: ViewPager, index: Int): View {
        return adapter.instantiateItem(parent, index) as View
    }
    @ReactMethod
     fun getNextPage(index: Int){
        viewPager.currentItem = index
    }
}