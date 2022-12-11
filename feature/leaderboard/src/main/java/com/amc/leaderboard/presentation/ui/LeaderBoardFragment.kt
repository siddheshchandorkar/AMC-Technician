package com.amc.leaderboard.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amc.leaderboard.R
import com.amc.leaderboard.databinding.FragmentLeaderBoardBinding
import com.amc.leaderboard.presentation.viewmodel.LeaderBoardViewModel

class LeaderBoardFragment : Fragment() {
    private lateinit var viewModel: LeaderBoardViewModel
    private lateinit var binding: FragmentLeaderBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_leader_board, container, false)
        viewModel = LeaderBoardViewModel(requireActivity().application)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }


}