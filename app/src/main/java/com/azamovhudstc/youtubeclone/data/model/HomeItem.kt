package com.azamovhudstc.youtubeclone.data.model

data class HomeItem(val dateAndView:String,val profileUrl:String,val title:String,val bannerRes:Int=0,val banner:String="",):AllData {
    override fun getType(): Int {
        return 1
    }
}