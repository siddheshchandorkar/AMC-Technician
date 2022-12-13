package com.amc.feedback

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.amc.common.BaseActivity
import com.amc.feedback.databinding.ActivityFeedbackFormBinding
import com.amc.feedback.domain.model.ExpensesModel
import com.amc.feedback.presentation.FeedBackFormViewModel
import com.amc.feedback.presentation.RowExpensesViewModel


class FeedbackFormActivity : BaseActivity() {
    private lateinit var viewModel: FeedBackFormViewModel
    private lateinit var binding: ActivityFeedbackFormBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feedback_form)
        viewModel = FeedBackFormViewModel()
        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.cvBack.setOnClickListener { finish() }
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, viewModel.expensesArrayLiveData.value!!
        )
        binding.actvExpenses.setAdapter(adapter)
        binding.actvExpenses.threshold = 1
        viewModel.clearSignature.observe(this) {
            binding.signaturePad.clear()
        }

        binding.actvExpenses.setOnItemClickListener { parent, view, position, id ->

            val item =
                binding.actvExpenses.adapter.getItem(position) as ExpensesModel
            val listService = viewModel.expensesListLiveData.value!!
            listService.add(RowExpensesViewModel(item))
            viewModel.expensesListLiveData.value = listService
            viewModel.expense.value = ""
//            binding.actvExpenses.clearFocus()
//            val manager: InputMethodManager = getSystemService(
//                Context.INPUT_METHOD_SERVICE
//            ) as InputMethodManager
//            manager
//                .hideSoftInputFromWindow(
//                    view.windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY
//                )
        }

        viewModel.submit.observe(this) {
            if (it) {
                val signatureBitmap: Bitmap = binding.signaturePad.signatureBitmap
                if (signatureBitmap == null) {
                    Toast.makeText(
                        this,
                        "Please Take Customer First to Submit Feedback",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    finish()
                }
            }

        }
    }


}