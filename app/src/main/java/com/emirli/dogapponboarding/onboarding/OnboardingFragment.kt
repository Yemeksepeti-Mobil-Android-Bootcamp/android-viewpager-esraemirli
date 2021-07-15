package com.emirli.dogapponboarding.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.emirli.dogapponboarding.R
import com.emirli.dogapponboarding.utils.ViewPagerAdapter
import com.emirli.dogapponboarding.utils.ZoomOutPageTransformer

class OnboardingFragment : Fragment() {
    private lateinit var viewPager : ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = view.findViewById(R.id.viewPager)
        initViewPager()
    }

    private fun initViewPager() {
        val fragmentList = arrayListOf(
            HealthFragment(),
            WalkingFragment(),
            NutritionFragment()
        )
        val adapter = ViewPagerAdapter(requireActivity(), fragmentList)
        viewPager.setPageTransformer(ZoomOutPageTransformer())
        viewPager.adapter = adapter
    }

}