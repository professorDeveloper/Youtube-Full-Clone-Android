package com.azamovhudstc.youtubeclone.data.model

data class ShortHomeItem(val list:ArrayList<ShortItem>,):AllData {
    override fun getType(): Int {
        return 2
    }
}