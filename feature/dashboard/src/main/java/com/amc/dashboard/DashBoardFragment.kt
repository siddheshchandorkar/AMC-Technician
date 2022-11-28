package com.amc.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amc.dashboard.databinding.FragmentDashboardBinding

class DashBoardFragment : Fragment() {
    private lateinit var viewModel: DashBoardViewModel
    private lateinit var binding: FragmentDashboardBinding
    var filterTypes =
        arrayOf("Select Filter Type", "Today", "Tomorrow", "Yesterday", "This Week", "Pending")

    companion object {
        const val TODAYS_LIST = "today_list"
        fun getInstance(bundle: Bundle): DashBoardFragment {
            val dashBoardFragment = DashBoardFragment()
            dashBoardFragment.arguments = bundle
            return dashBoardFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        viewModel = DashBoardViewModel(requireActivity().application)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.clTomorrow.setOnClickListener {
            val intent = Intent(requireContext(), ServiceListActivity::class.java)
            intent.putExtra(ServiceListActivity.SERVICE_TYPE, 0)
            startActivity(intent)
        }
        binding.clYesterday.setOnClickListener {
            val intent = Intent(requireContext(), ServiceListActivity::class.java)
            intent.putExtra(ServiceListActivity.SERVICE_TYPE, 1)
            startActivity(intent)
        }
        binding.clThisWeek.setOnClickListener {
            val intent = Intent(requireContext(), ServiceListActivity::class.java)
            intent.putExtra(ServiceListActivity.SERVICE_TYPE, 2)
            startActivity(intent)
        }
        binding.clPending.setOnClickListener {
            val intent = Intent(requireContext(), ServiceListActivity::class.java)
            intent.putExtra(ServiceListActivity.SERVICE_TYPE, 3)
            startActivity(intent)
        }
        binding.tvViewAll.setOnClickListener {
            val intent = Intent(requireContext(), ServiceListActivity::class.java)
            intent.putExtra(ServiceListActivity.SERVICE_TYPE, 4)
            startActivity(intent)
        }

//        arguments?.let {
//            if(it.containsKey(TODAYS_LIST)){
//                viewModel.isTodayList.value=(it.getBoolean(TODAYS_LIST,false))
//                viewModel.listVisibility.value=(viewModel.isTodayList.value)
//             }else{
//                val adapter
//                        = ArrayAdapter(requireContext(),
//                    android.R.layout.simple_list_item_1, filterTypes)
//                adapter.setDropDownViewResource(
//                    android.R.layout.simple_spinner_dropdown_item
//                )
//
////                binding.spFilterType.adapter = adapter
////
////                binding.spFilterType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
////                    override fun onItemSelected(
////                        parent: AdapterView<*>?,
////                        view: View?,
////                        position: Int,
////                        id: Long
////                    ) {
////                        if(position===0){
////                            viewModel.listVisibility.postValue(false)
////
////                        }else{
////                            viewModel.listVisibility.postValue(true)
////
////                        }
////
////
////                    }
////
////                    override fun onNothingSelected(parent: AdapterView<*>?) {
////
////                    }
////
////                }
//            }
//        }


        return binding.root
    }


}