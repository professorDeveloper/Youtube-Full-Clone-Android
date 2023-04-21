package com.azamovhudstc.youtubeclone.ui.screen.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.azamovhudstc.youtubeclone.R
import com.azamovhudstc.youtubeclone.data.model.CategoryItem
import com.azamovhudstc.youtubeclone.ui.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.home_screen.*

class HomeScreen:Fragment(R.layout.home_screen) {
    private val categoryAdapter by lazy { CategoryAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAndListenCategoryRv()
    }

    private fun initAndListenCategoryRv(){
        category_rv.adapter=categoryAdapter
        categoryAdapter.submitList(loadData())
        categoryAdapter.setItemClickListener {
            println(it.title)
        }
    }

    private fun loadData():ArrayList<CategoryItem>{
        val arrayList =ArrayList<CategoryItem>()
        arrayList.add(CategoryItem("All"))
        arrayList.add(CategoryItem("Mixes"))
        arrayList.add(CategoryItem("Graphic"))
        arrayList.add(CategoryItem("Gaming"))
        arrayList.add(CategoryItem("Humans"))
        arrayList.add(CategoryItem("Comedy"))
        arrayList.add(CategoryItem("Rapping"))
        return arrayList
    }
}