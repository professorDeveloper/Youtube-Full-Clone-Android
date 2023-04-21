package com.azamovhudstc.youtubeclone.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.youtubeclone.R
import com.azamovhudstc.youtubeclone.data.model.CategoryItem
import com.azamovhudstc.youtubeclone.utils.dpToPx
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryVh>() {
    private val list = ArrayList<CategoryItem>()
    private var checkedPosition = 0
    private  lateinit var itemClickListener:((CategoryItem)->Unit)

    fun setItemClickListener(listener:(CategoryItem)->Unit){
        itemClickListener=listener
    }

    inner class CategoryVh(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(data: CategoryItem) {
            itemView.apply {
                category_title.text = data.title.toString()
                if (checkedPosition == -1) {
                    container.setBackgroundResource(R.drawable.category_bg)
                    category_title.setTextColor(Color.BLACK)
                    category_title.layoutParams.width = WRAP_CONTENT
                    category_title.layoutParams.height = 30.dpToPx
                } else {
                    if (checkedPosition == adapterPosition) {
                        container.setBackgroundResource(R.drawable.category_darck_bg)
                        category_title.setTextColor(Color.WHITE)
                        category_title.layoutParams.width = WRAP_CONTENT
                        category_title.layoutParams.height = 30.dpToPx
                    } else {
                        container.setBackgroundResource(R.drawable.category_bg)
                        category_title.setTextColor(Color.BLACK)
                        category_title.layoutParams.width = WRAP_CONTENT
                        category_title.layoutParams.height = 30.dpToPx
                    }
                }
            }



            itemView.setOnClickListener {
                itemView.apply {
                    container.setBackgroundResource(R.drawable.category_darck_bg)
                    category_title.setTextColor(Color.WHITE)
                    category_title.layoutParams.width = WRAP_CONTENT
                    category_title.layoutParams.height = 30.dpToPx
                    if (checkedPosition != adapterPosition) {
                        notifyItemChanged(checkedPosition)
                        checkedPosition = adapterPosition
                        itemClickListener.invoke(data)
                    }else{
                        itemClickListener.invoke(data)
                    }
                }
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVh {
        return CategoryVh(
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryVh, position: Int) {
        holder.onBind(
            list[position]
        )
    }

    fun submitList(newList: List<CategoryItem>) {
        list.clear()
        list.addAll(newList)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}