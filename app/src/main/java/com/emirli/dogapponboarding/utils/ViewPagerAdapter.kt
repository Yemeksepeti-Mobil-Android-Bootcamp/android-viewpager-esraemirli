package com.emirli.dogapponboarding.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val FRAGMENT_COUNT = 3

class ViewPagerAdapter(
    activity: FragmentActivity,
    private val fragmentList: ArrayList<Fragment>) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}