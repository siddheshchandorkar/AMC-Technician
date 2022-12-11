package com.amc.expenses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amc.common.BaseActivity

class AddExpensesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expenses)
    }
}