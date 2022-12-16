package com.amc.technician.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amc.common.BaseActivity
import com.amc.dashboard.DashBoardFragment
import com.amc.leaderboard.presentation.ui.LeaderBoardFragment
import com.amc.notification.presentation.ui.NotificationFragment
import com.amc.technician.R
import com.amc.technician.databinding.ActivityMainBinding
import com.amc.technician.presentation.AppNavigation
import com.amc.technician.presentation.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private var selectedTab = DASHBOARD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainActivityViewModel(application)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        addFragment(binding.container.id, DashBoardFragment.getInstance(Bundle()))

        binding.bottomNavigationView.background = null

        binding.fab.setOnClickListener {
            AppNavigation.navigateToEnquiryActivity(this@MainActivity)
        }

        binding.bottomNavigationView.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.tab_dashboard -> {
                    if (selectedTab != DASHBOARD) {
                        replaceFragment(
                            binding.container.id,
                            DashBoardFragment.getInstance(Bundle())
                        )
                        selectedTab = DASHBOARD
                    }
                }
                R.id.tab_leader_board -> {
                    if (selectedTab != LEADERBOARD) {
                        replaceFragment(binding.container.id, LeaderBoardFragment())
                        selectedTab = LEADERBOARD
                    }
                }
                R.id.tab_notification -> {
                    if (selectedTab != NOTIFICATION) {
                        replaceFragment(binding.container.id, NotificationFragment())
                        selectedTab = NOTIFICATION
                    }
                }
                R.id.tab_today -> {
                    if (selectedTab != ADD_ENQUIRY) {
                        replaceFragment(
                            binding.container.id,
                            DashBoardFragment.getInstance(Bundle())
                        )
                        selectedTab = ADD_ENQUIRY
                    }
                }
            }
            return@setOnItemSelectedListener true

        }

    }

    fun AppCompatActivity.addFragment(frameId: Int, fragment: Fragment) {
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
        const val ADD_ENQUIRY = 3
    }
}