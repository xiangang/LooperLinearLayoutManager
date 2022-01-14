package com.nxg.app.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.nxg.app.widget.databinding.MainFragmentBinding
import com.nxg.recyclerview.widget.LooperLinearLayoutManager


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private val dataList = mutableListOf<BannerBean>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
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

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.bannerList.observe(viewLifecycleOwner, Observer {
            dataList.clear()
            dataList.addAll(it)
            bannerAdapter.notifyDataSetChanged()
        })
        return root
    }

}