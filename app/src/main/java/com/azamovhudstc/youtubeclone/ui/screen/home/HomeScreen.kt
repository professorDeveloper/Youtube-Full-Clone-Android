package com.azamovhudstc.youtubeclone.ui.screen.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.azamovhudstc.youtubeclone.R
import com.azamovhudstc.youtubeclone.data.model.*
import com.azamovhudstc.youtubeclone.ui.adapter.CategoryAdapter
import com.azamovhudstc.youtubeclone.ui.adapter.HomeVideoAdapter
import kotlinx.android.synthetic.main.home_screen.*

class HomeScreen : Fragment(R.layout.home_screen) {
    private val categoryAdapter by lazy { CategoryAdapter() }
    private val homeAdapter by lazy { HomeVideoAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAndListenCategoryRv()
        initHomeRv()
    }

    private fun initAndListenCategoryRv() {
        category_rv.adapter = categoryAdapter
        categoryAdapter.submitList(loadData())
        categoryAdapter.setItemClickListener {
            println(it.title)
        }
    }

    private fun initHomeRv() {
        home_rv.adapter=homeAdapter
        homeAdapter.submitList(loadDataHome())

    }

    private fun loadData(): ArrayList<CategoryItem> {
        val arrayList = ArrayList<CategoryItem>()
        arrayList.add(CategoryItem("All"))
        arrayList.add(CategoryItem("Mixes"))
        arrayList.add(CategoryItem("Graphic"))
        arrayList.add(CategoryItem("Gaming"))
        arrayList.add(CategoryItem("Humans"))
        arrayList.add(CategoryItem("Comedy"))
        arrayList.add(CategoryItem("Rapping"))
        return arrayList
    }

    private fun loadDataHome(): ArrayList<AllData> {
        val arrayList = ArrayList<AllData>()
        arrayList.add(
            HomeItem(
                title = "Phonk Music 2023 ※ Aggressive Drift Phonk ※ Фонк 2023",
                banner = "https://i.ytimg.com/vi/IMp9bwsqF7I/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLConwsyJRkiX8Q8PNsy5OfbB3umog",
                dateAndView = "232,526 views  16 Mar 2023",
                profileUrl = "https://yt3.googleusercontent.com/8aKzIdHYClPdf7boaswfgeDJIyizKXfmv0X1hTrwCkRkuPLuvnvFAY5YCXx4WibICSm1AG32=s176-c-k-c0x00ffffff-no-rj"
            )
        )
        arrayList.add(ShortHomeItem(list = loadShortData()))


        arrayList.add(
            HomeItem(
                title = "Phonk Music 2023 ※ Aggressive Drift Phonk ※ Фонк 2023",
                banner = "https://i.ytimg.com/vi/hhOQT693q00/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCAIuahyI9FZz9YcYNJVywYUoUQ8g",
                dateAndView = "32,717,987 views  24 Aug 2022",
                profileUrl = "https://yt3.googleusercontent.com/NH6N10zQxcbYHeARPqM4b4zgW0lvHvl4CmBHOyKJ9pbKQ6hU8JKO9W4_mxFmVpw8Uq3lVoICKw=s176-c-k-c0x00ffffff-no-rj"
            )
        )

        arrayList.add(
            HomeItem(
                title = "Phonk Music 2023 ※ Sigma Phonk ※ Фонк 2023",
                banner = "https://i.ytimg.com/vi/VG90vMD-0s8/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLC1N4_E1IPgEbX_7RuL7fy0WTFhKQ",
                dateAndView = "874,075 views  27 Feb 2023  16 Mar 2023",
                profileUrl = "https://yt3.googleusercontent.com/4RHObckSZMLLb39v17n6P57MAbE_ECGQABtyAoTb5PrLzaCvTG6xVqNh9Ch8rFrf9Q-7N7tI4g=s176-c-k-c0x00ffffff-no-rj"
            )
        )
        return arrayList
    }

    private fun loadShortData(): ArrayList<ShortItem> {
        val arrayList = ArrayList<ShortItem>()
        arrayList.add(
            ShortItem(
                views = "524K views",
                title = "This Phonk playlist will unleash your monster \uD83D\uDE08",
                bannerWithUrl = "https://i.ytimg.com/vi/d6WNfuhyEZw/oar2.jpg?sqp=-oaymwEaCJUDENAFSFXyq4qpAwwIARUAAIhCcAHAAQY=&rs=AOn4CLDaYu-IONtHwB0gc3PnRxA_h3YLwg"
            )
        )
        arrayList.add(
            ShortItem(
                views = "2K views",
                title = "Transparent Status Bar In Android In Less Than a",
                bannerWithUrl = "https://i.ytimg.com/vi/nzQ4HE0DMDg/oar2.jpg?sqp=-oaymwEaCJUDENAFSFXyq4qpAwwIARUAAIhCcAHAAQY=&rs=AOn4CLBT0h_UfNCyUY3mgSbcgisblUA2Rw"
            )
        )
        arrayList.add(
            ShortItem(
                views = "10K views",
                title = "This Is NOT Dependency Injection",
                bannerWithUrl = "https://i.ytimg.com/vi/XROweIrJdqA/oar2.jpg?sqp=-oaymwEaCJUDENAFSFXyq4qpAwwIARUAAIhCcAHAAQY=&rs=AOn4CLAEpedihRxdGUb4_6bunIFNMfzCvw"
            )
        )
        arrayList.add(
            ShortItem(
                views = "1.3M views",
                title = "Sigma Phonk. Are you a real fan of Phonk Music ???",
                bannerWithUrl = "https://i.ytimg.com/vi/k926SYLAZ-s/oar2.jpg?sqp=-oaymwEaCJUDENAFSFXyq4qpAwwIARUAAIhCcAHAAQY=&rs=AOn4CLDp5EeBYeNxTCsLRWTBG1YtkqE6rQ"
            )
        )

        return arrayList
    }
}