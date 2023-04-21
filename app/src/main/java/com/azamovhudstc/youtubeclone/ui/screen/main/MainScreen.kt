package com.azamovhudstc.youtubeclone.ui.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.youtubeclone.R
import com.azamovhudstc.youtubeclone.ui.adapter.MainBottomViewAdapter
import kotlinx.android.synthetic.main.main_screen.*

class MainScreen : Fragment(R.layout.main_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        val categoryAdapter = MainBottomViewAdapter(requireActivity())
        viewpager2_main.adapter = categoryAdapter
        viewpager2_main.isUserInputEnabled = false
        viewpager2_main.setOnTouchListener(null)
        bottom_navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> {
                    viewpager2_main.currentItem = 0
                    bottom_navigation.getMenu().getItem(0).setChecked(true);
                }
                R.id.short_item -> {
                    viewpager2_main.currentItem = 1
                    bottom_navigation.getMenu().getItem(1).setChecked(true);
                }
                R.id.subscribe -> {
                    viewpager2_main.currentItem = 2
                    bottom_navigation.getMenu().getItem(2).setChecked(true); }
                R.id.library -> {
                    viewpager2_main.currentItem = 3
                    bottom_navigation.getMenu().getItem(3).setChecked(true);

                }
            }

            true
        }
    }
}