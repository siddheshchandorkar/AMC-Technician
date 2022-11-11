package com.amc.technician.presentation.ui

import android.os.Bundle
import android.system.Os.remove
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amc.dashboard.DashBoardFragment
import com.amc.leaderboard.presentation.ui.LeaderBoardFragment
import com.amc.notification.presentation.ui.NotificationFragment
import com.amc.technician.R
import com.amc.technician.databinding.ActivityMainBinding
import com.amc.technician.presentation.AppNavigation
import com.amc.technician.presentation.viewmodel.MainActivityViewModel
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainActivityViewModel(application)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        addFragment(binding.container.id, DashBoardFragment())

        binding.bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                if (lastIndex != newIndex) {
                    when (newIndex) {
                        DASHBOARD -> {
//                            AppNavigation.navigateToDashboard(this@MainActivity)
                            replaceFragment(binding.container.id, DashBoardFragment())
                        }
                        LEADERBOARD -> {
                            replaceFragment(binding.container.id, LeaderBoardFragment())
                        }
                        NOTIFICATION -> {
                            replaceFragment(binding.container.id, NotificationFragment())
                        }
                        TODAYS_CALL -> {
                            replaceFragment(binding.container.id, DashBoardFragment())
                        }
                    }
                }

                Log.d("bottom_bar", "Selected index: $newIndex, title: ${newTab.title}")
            }

            // An optional method that will be fired whenever an already selected tab has been selected again.
            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
                Log.d("bottom_bar", "Reselected index: $index, title: ${tab.title}")
            }
        })
    }

    fun AppCompatActivity.addFragment(frameId: Int,fragment: Fragment){
        val fr = supportFragmentManager.beginTransaction()
        fr.add(frameId, fragment)
        fr.commit()
    }


    fun AppCompatActivity.replaceFragment(frameId: Int, fragment: Fragment) {
        val fr = supportFragmentManager.beginTransaction()
        fr.setCustomAnimations(
             R.anim.slide_in,
            R.anim.fade_out
        )
        fr.replace(frameId, fragment)
        fr.commit()
    }

    companion object {
        const val DASHBOARD = 0
        const val LEADERBOARD = 1
        const val NOTIFICATION = 2
        const val TODAYS_CALL = 3
    }
}