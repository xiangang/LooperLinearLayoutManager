package com.nxg.app.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _bannerList = MutableLiveData<List<BannerBean>>().apply {
        value = loadBannerData()
    }
    val bannerList: LiveData<List<BannerBean>> = _bannerList

    private fun loadBannerData(): List<BannerBean> {
        val bannerList = mutableListOf<BannerBean>()
        bannerList.add(
            BannerBean(
                "水晶玫瑰系列 今日上线",
                "水晶玫瑰系列 今日上线",
                "https://img.tgl.qq.com/cover/20220109/752fc43b726f8fb71c3ac2e05fe3eb05_1641668885.jpg"
            )
        )
        bannerList.add(
            BannerBean(
                "英雄联盟手游 2022版本前瞻",
                "英雄联盟手游 2022版本前瞻",
                "https://img.tgl.qq.com/cover/20211130/9e25cb9ab0419da1f8b965755347e66f_1638236038.jpg"
            )
        )
        bannerList.add(
            BannerBean(
                "《英雄联盟手游》电玩系列皮肤今日上线！",
                "《英雄联盟手游》电玩系列皮肤今日上线！",
                "https://img.tgl.qq.com/cover/20211215/a8ea448cd0b6a6ad024b81ad36535f7a_1639533555.jpg"
            )
        )
        bannerList.add(
            BannerBean(
                "2.6版本开发者日志",
                "2.6版本开发者日志",
                "https://img.tgl.qq.com/cover/20220107/b3d5e42cd57b71a4ba696f915be893f3_1641569759.jpg"
            )
        )
        return bannerList
    }
}