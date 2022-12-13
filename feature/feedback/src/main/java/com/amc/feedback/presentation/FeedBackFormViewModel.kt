package com.amc.feedback.presentation

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amc.common.BaseRowModel
import com.amc.feedback.domain.model.ExpensesModel
import com.github.gcacace.signaturepad.views.SignaturePad

class FeedBackFormViewModel : ViewModel() {

    var isExpenses = MutableLiveData(false)
    var expense = MutableLiveData("")
    var material1 = MutableLiveData("")
    var material2 = MutableLiveData("")
    var submit = MutableLiveData(false)
    var clearSignature = MutableLiveData(false)
    var isSigned = MutableLiveData(false)
    var saveSignature = MutableLiveData(false)
    var expensesListLiveData: MutableLiveData<MutableList<BaseRowModel>> = MutableLiveData()
    var expensesArrayLiveData = MutableLiveData<Array<ExpensesModel>?>(emptyArray())

    init {
        val listService = mutableListOf<BaseRowModel>()
//        listService.add(RowExpensesViewModel(ExpensesModel("Solution", 250, "gm")))
//        listService.add(RowExpensesViewModel(ExpensesModel("Solution", 250, "gm")))

        val listExpenses = arrayOf(
            ExpensesModel("Solution", 0, ""),
            ExpensesModel("Solution 1", 0, ""),
            ExpensesModel("Solution 2", 0, ""),
            ExpensesModel("Solution 3", 0, ""),
            ExpensesModel("Material", 0, ""),
            ExpensesModel("Material 1", 0, ""),
            ExpensesModel("Material 2", 0, ""),
            ExpensesModel("Material 3", 0, "")
        )

        expensesArrayLiveData.value = listExpenses
//        val listService = mutableListOf<BaseRowModel>()
//        listService.add(RowExpensesViewModel(ExpensesModel("Solution", 250, "gm")))
//        listService.add(RowExpensesViewModel(ExpensesModel("Solution", 250, "gm")))
//
        expensesListLiveData.value = listService
    }

    val signatureListener = object : SignaturePad.OnSignedListener {
        override fun onStartSigning() {
            isSigned.value = true

        }

        override fun onSigned() {
            isSigned.value = true
        }

        override fun onClear() {
            isSigned.value = false
        }

    }

    fun onClearSignature(view: View) {
        clearSignature.value = true
    }

    fun submitFeedback(view: View) {
        if (isExpenses.value!!) {
            submit.value = true

//            when {
//                TextUtils.isEmpty(material1.value) -> {
//                    Toast.makeText(
//                        view.context,
//                        "Please enter quantity for Material 1",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//                TextUtils.isEmpty(material2.value) -> {
//                    Toast.makeText(
//                        view.context,
//                        "Please enter quantity for Material 2",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//                !isSigned.value!!->{
//                    Toast.makeText(
//                        view.context,
//                        "Please Take Customer Signature",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//                else -> {
//                    submit.value = true
//                }
//
//            }
        } else {
            when {
                !isSigned.value!! -> {
                    Toast.makeText(
                        view.context,
                        "Please Take Customer Signature",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    submit.value = true
                }
            }
        }
    }


}