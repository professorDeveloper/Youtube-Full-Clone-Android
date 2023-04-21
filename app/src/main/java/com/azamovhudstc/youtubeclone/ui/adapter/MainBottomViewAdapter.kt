package com.azamovhudstc.youtubeclone.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.azamovhudstc.youtubeclone.ui.screen.home.HomeScreen
import com.azamovhudstc.youtubeclone.ui.screen.library.LibraryScreen
import com.azamovhudstc.youtubeclone.ui.screen.shorts.ShortsScreen
import com.azamovhudstc.youtubeclone.ui.screen.subscribe.SubscribeScreen

class MainBottomViewAdapter(fragmentManager: FragmentActivity) :
    FragmentStateAdapter(fragmentManager) {


    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeScreen()
            }
            1 -> {
                ShortsScreen()
            }
            2 -> {
                LibraryScreen()
            }
            else -> {
                SubscribeScreen()
            }
        }

    }
}