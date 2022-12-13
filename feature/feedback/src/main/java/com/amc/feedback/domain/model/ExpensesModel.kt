package com.amc.feedback.domain.model

public data class ExpensesModel(var materialName:String,var quantity: Int, var unit:String)
{
    override fun toString(): String {
        return materialName
    }
}
