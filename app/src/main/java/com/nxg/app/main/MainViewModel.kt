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
        val data = mutableListOf<BannerBean>()
        data.add(
            BannerBean(
                "水晶玫瑰系列 今日上线",
                "水晶玫瑰系列 今日上线",
                "https://img.tgl.qq.com/cover/20220109/752fc43b726f8fb71c3ac2e05fe3eb05_1641668885.jpg"
            )
        )
        data.add(
            BannerBean(
                "英雄联盟手游 2022版本前瞻",
                "英雄联盟手游 2022版本前瞻",
                "https://img.tgl.qq.com/cover/20211130/9e25cb9ab0419da1f8b965755347e66f_1638236038.jpg"
            )
        )
        data.add(
            BannerBean(
                "《英雄联盟手游》电玩系列皮肤今日上线！",
                "《英雄联盟手游》电玩系列皮肤今日上线！",
                "https://img.tgl.qq.com/cover/20211215/a8ea448cd0b6a6ad024b81ad36535f7a_1639533555.jpg"
            )
        )
        data.add(
            BannerBean(
                "2.6版本开发者日志",
                "2.6版本开发者日志",
                "https://img.tgl.qq.com/cover/20220107/b3d5e42cd57b71a4ba696f915be893f3_1641569759.jpg"
            )
        )
        data.add(
            BannerBean(
                "周免英雄",
                "周免英雄",
                "https://img.tgl.qq.com/cover/20220114/edfb37ff28423a26f7ada078cb0c78ff_1642145711.png"
            )
        )
        data.add(
            BannerBean(
                "《英雄联盟手游》冬季战斗学院特惠宝箱概率公示",
                "《英雄联盟手游》冬季战斗学院特惠宝箱概率公示",
                "https://img.tgl.qq.com/cover/20220110/eae015efdcef45358a133305874af484_1641796514.jpg"
            )
        )
        data.add(
            BannerBean(
                "心萦水晶 情寄玫瑰“活动预告",
                "心萦水晶 情寄玫瑰“活动预告",
                "https://img.tgl.qq.com/cover/20220108/dd3981fcd45bb510e9aadc473559fe90_1641572325.png"
            )
        )
        data.add(
            BannerBean(
                "水晶玫瑰 娑娜",
                "水晶玫瑰 娑娜",
                "https://img.tgl.qq.com/cover/20220107/37990d1080aa2739be039a5cae282f41_1641525542.png"
            )
        )
        return data
    }
}