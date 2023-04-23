package com.azamovhudstc.youtubeclone.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.youtubeclone.R
import com.azamovhudstc.youtubeclone.data.model.ShortHomeItem
import com.azamovhudstc.youtubeclone.data.model.ShortItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.short_home_item.view.*

class HomeShortsAdapter :androidx.recyclerview.widget.ListAdapter<ShortItem,HomeShortsAdapter.ShortVh>(HomeShortItemCallback) {


    inner class  ShortVh(view:View):RecyclerView.ViewHolder(view)
    {
        fun onBind(data:ShortItem){
            itemView.apply {
                if (data.bannerWithUrl.isNotEmpty()){
                    Glide.with(context).load(data.bannerWithUrl).into(
                        short_banner_img
                    )
                }else{

                    short_banner_img.setImageResource(data.banner)
                }
                title_shorts.text=data.title
                views_shorts.text=data.views
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortVh {
        return  ShortVh(LayoutInflater.from(parent.context).inflate(R.layout.short_home_item,parent,false))
    }

    override fun onBindViewHolder(holder: ShortVh, position: Int) {
        holder.onBind(getItem(position))
    }
    object HomeShortItemCallback: DiffUtil.ItemCallback<ShortItem>() {
        override fun areItemsTheSame(oldItem: ShortItem, newItem: ShortItem): Boolean {
            return oldItem==newItem}

        override fun areContentsTheSame(oldItem: ShortItem, newItem: ShortItem): Boolean {
            return  oldItem==newItem
        }

    }

}