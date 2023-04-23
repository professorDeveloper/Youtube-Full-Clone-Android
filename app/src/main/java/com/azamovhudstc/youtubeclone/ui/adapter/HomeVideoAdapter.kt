package com.azamovhudstc.youtubeclone.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.youtubeclone.R
import com.azamovhudstc.youtubeclone.data.model.AllData
import com.azamovhudstc.youtubeclone.data.model.HomeItem
import com.azamovhudstc.youtubeclone.data.model.ShortHomeItem
import com.azamovhudstc.youtubeclone.data.model.ShortItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.home_video_item.view.*
import kotlinx.android.synthetic.main.shorts_item.view.*

class HomeVideoAdapter: RecyclerView.Adapter<HomeVideoAdapter.AllHolder>() {
    val list:ArrayList<AllData> = ArrayList()

    abstract inner class AllHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind()
    }

    inner class  HomeVh(view:View):AllHolder(view){
        override fun bind() {
            val itemData =list.get(adapterPosition) as HomeItem
            itemView.apply {
                if (itemData.banner.isNotEmpty()){
                    Glide.with(context).load(itemData.banner).into(banner_img)
                }else{
                    banner_img.setImageResource(itemData.bannerRes)

                }
                video_name.text=itemData.title
                Glide.with(context).load(itemData.profileUrl).into(channel_profile_img)
                video_date_and_views.text=itemData.dateAndView
            }

        }
    }
    inner class  ShortsHomeVh(view: View): AllHolder(view){
        override fun bind() {
            val itemData =list.get(adapterPosition) as ShortHomeItem
            itemView.apply {
                val adapter =HomeShortsAdapter()
                short_home_rv.adapter =adapter
                adapter.submitList(itemData.list)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllHolder {
        val allHolder =when(viewType){
            1->HomeVh(LayoutInflater.from(parent.context).inflate(R.layout.home_video_item,parent,false))
            else->ShortsHomeVh(LayoutInflater.from(parent.context).inflate(R.layout.shorts_item,parent,false))
        }
        return allHolder
    }

    override fun onBindViewHolder(holder: AllHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitList(newList:ArrayList<AllData>){
        list.clear()
        list.addAll(newList)
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].getType()
    }
}