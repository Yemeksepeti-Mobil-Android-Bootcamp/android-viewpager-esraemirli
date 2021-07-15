package com.emirli.dogapponboarding.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.emirli.dogapponboarding.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class NutritionFragment : Fragment() {
    private lateinit var title: AppCompatTextView
    private lateinit var explanation: AppCompatTextView
    private lateinit var image: AppCompatImageView
    private lateinit var skipButton: FloatingActionButton
    private lateinit var startButton: AppCompatButton
    private var viewPager: ViewPager2? = null
    private lateinit var dot: SpringDotsIndicator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nutrition, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setFields()
        addListener()
    }

    private fun initViews(view: View) {
        viewPager = activity?.findViewById(R.id.viewPager)
        dot = view.findViewById(R.id.springDotsIndicator)
        title = view.findViewById(R.id.titleTextView)
        explanation = view.findViewById(R.id.explanationTextView)
        image = view.findViewById(R.id.imageView)
        skipButton = view.findViewById(R.id.skipFab)
        startButton = view.findViewById(R.id.startButton)
    }

    private fun setFields() {
        viewPager?.let { dot.setViewPager2(it) }
        title.text = String.format(resources.getString(R.string.nutrition_title))
        explanation.text = String.format(resources.getString(R.string.nutrition_text))
        image.setImageResource(R.drawable.nutrition)
        skipButton.visibility = View.GONE
        startButton.visibility = View.VISIBLE
    }

    private fun addListener() {
        startButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_homeFragment)
        }
    }

}