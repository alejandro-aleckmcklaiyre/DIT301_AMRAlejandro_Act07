package com.example.advanceuinavapp.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.advanceuinavapp.fragments.InfoFragment
import com.example.advanceuinavapp.fragments.GalleryFragment

/**
 * Adapter for ViewPager2 that manages nested fragments (InfoFragment and GalleryFragment)
 * within the ProfileFragment.
 * 
 * This adapter demonstrates the pattern for nesting ViewPager2 inside a Fragment
 * that is itself managed by a NavHostFragment.
 */
class ProfilePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> InfoFragment()
            1 -> GalleryFragment()
            else -> InfoFragment()
        }
    }
}
