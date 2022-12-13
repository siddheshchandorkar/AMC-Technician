package com.amc.feedback.presentation

import androidx.lifecycle.MutableLiveData
import com.amc.common.BaseRowModel
import com.amc.feedback.R
import com.amc.feedback.domain.model.ExpensesModel

class RowExpensesViewModel(expensesModel: ExpensesModel) : BaseRowModel() {
    var materialName = MutableLiveData("")
    var quantity = MutableLiveData("")
    var unit = MutableLiveData("")

    override fun setLayoutID() {
        layoutID = R.layout.row_expenses
    }

    init {
        materialName.value = expensesModel.materialName
        quantity.value = expensesModel.quantity.toString()
        unit.value = expensesModel.unit
    }
}