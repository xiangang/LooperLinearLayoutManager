# 1.LooperLinearLayoutManager项目介绍
 > 🍎 `LooperLinearLayoutManager` 基于Android官方LinearLayoutManager源码修改实现的支持无限循环的LayoutManager。

[![](https://jitpack.io/v/xiangang/LooperLinearLayoutManager.svg)](https://jitpack.io/#xiangang/LooperLinearLayoutManager)

# 2. 效果展示

![演示图](https://github.com/xiangang/LooperLinearLayoutManager/blob/main/demo.gif)

# 3. 使用方法：

第一步：
在你的根目录中的  build.gradle 文件中，repositories 标签下添加jitpack maven仓库：

Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
    	...
    	maven { url 'https://jitpack.io' }
    }
}

```
若使用Gradle 7.0 ，则在setting.gradle中的dependencyResolutionManagement的repositories标签中添加：
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
		...
        maven { url 'https://jitpack.io' }
        ...
    }
}
...

```

第二步：
添加依赖
Add the dependency

```
dependencies {
	implementation 'com.github.xiangang:LooperLinearLayoutManager:v1.0.0-alpha01'
}

```

# 4. 使用示例
跟原来的使用LinearLayoutManager一模一样，只需将LinearLayoutManager替换为LooperLinearLayoutManager。
```kotlin
val bannerAdapter = BannerAdapter(requireContext(), dataList)
bannerRecyclerView.layoutManager = LooperLinearLayoutManager(
    requireContext(), RecyclerView.HORIZONTAL, false
)
bannerRecyclerViewVertical.layoutManager = LooperLinearLayoutManager(
    requireContext(), RecyclerView.VERTICAL, false
)
```


# 5. 配合PagerSnapHelper使用实现类似ViewPager的无限循环功能
注意，若使用LinearSnapHelper，将由于LinearSnapHelper本身的限制而失去无限循环的能力。因此LooperLinearLayoutManager建议只搭配PagerSnapHelper实现无限循环的效果。若一定要使用LinearSnapHelper，建议新建一个LooperLinearSnapHelper类继承LinearSnapHelper并重写findTargetSnapPosition解除无循环限制。

```kotlin
val bannerRecyclerView = binding.bannerRecyclerview
val bannerRecyclerViewVertical = binding.bannerRecyclerviewVertical

val bannerAdapter = BannerAdapter(requireContext(), dataList)
bannerRecyclerView.layoutManager = LooperLinearLayoutManager(
    requireContext(), RecyclerView.HORIZONTAL, false
)
bannerRecyclerViewVertical.layoutManager = LooperLinearLayoutManager(
    requireContext(), RecyclerView.VERTICAL, false
)

val snapHelper = PagerSnapHelper()
snapHelper.attachToRecyclerView(bannerRecyclerView)
val snapHelperVertical = PagerSnapHelper()
snapHelperVertical.attachToRecyclerView(bannerRecyclerViewVertical)

bannerRecyclerView.adapter = bannerAdapter
bannerRecyclerViewVertical.adapter = bannerAdapter
```

# License
```text
Copyright 2022 xiangang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

