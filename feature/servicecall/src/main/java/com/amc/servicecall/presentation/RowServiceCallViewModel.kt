package com.amc.servicecall.presentation

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.text.format.DateFormat
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.databinding.ObservableField
import com.amc.common.BaseRowModel
import com.amc.common.ui.PinEntryEditText
import com.amc.feedback.FeedbackFormActivity
import com.amc.servicecall.R
import com.amc.servicecall.data.ServiceCallModel
import java.util.*


class RowServiceCallViewModel(serviceCallModel: ServiceCallModel) :
    BaseRowModel() {
    var srNo = ObservableField(serviceCallModel.srNo.toString())
    var inTime = ObservableField(serviceCallModel.inTime)
    var outTime = ObservableField(serviceCallModel.outTime)
    var isVerified = ObservableField(serviceCallModel.verified)
    var feedGiven = ObservableField(isVerified.get())
    var calInTime = Calendar.getInstance()
    var calOutTime = Calendar.getInstance()


    override fun setLayoutID() {
        layoutID = R.layout.row_service_call
    }

    fun openInTimer(view: View) {
        openTimeSelector(true, view.context)
    }

    fun openOutTimer(view: View) {
        openTimeSelector(false, view.context)
    }

    private fun openTimeSelector(isInTime: Boolean, context: Context) {
        var hrs=0
        var min=0
        if(isInTime){
            hrs=calInTime.get(Calendar.HOUR_OF_DAY)
           min= calInTime.get(Calendar.MINUTE)
        }else{
            hrs=calOutTime.get(Calendar.HOUR_OF_DAY)
            min= calOutTime.get(Calendar.MINUTE)
        }
        val tpd = TimePickerDialog(context,
            { view1: TimePicker?, hourOfDay: Int, minute: Int ->
                if (isInTime) {
                        inTime.set("${String.format("%02d", hourOfDay)}:${String.format(
                            "%02d",
                            minute
                        )}")
                    } else {
                        outTime.set("${String.format("%02d", hourOfDay)}:${String.format(
                            "%02d",
                            minute
                        )}")
                    }
            },hrs,min, DateFormat.is24HourFormat(context)
        )
        tpd.show()
//        val mcurrentTime: Calendar = Calendar.getInstance()
//        val hour: Int = mcurrentTime.get(Calendar.HOUR_OF_DAY)
//        val minute: Int = mcurrentTime.get(Calendar.MINUTE)
//        val mTimePicker =
//            TimePickerDialog(
//                context,
//                { view, hourOfDay, minute ->
//                    if (isInTime) {
//                        inTime.set("$hourOfDay:$minute")
//                    } else {
//                        outTime.set("$hourOfDay:$minute")
//                    }
//                }, hour, minute, true
//            ) //Yes 24 hour time
//
//        if (isInTime) {
//            mTimePicker.setTitle("Select In Time")
//        } else {
//            mTimePicker.setTitle("Select Out Time")
//
//        }
//        mTimePicker.show()
    }

    fun serviceFeedBack(view: View){
        when{
            TextUtils.isEmpty(inTime.get()) -> {
                Toast.makeText(view.context, "Please Select In Time", Toast.LENGTH_SHORT).show()
            }
            TextUtils.isEmpty(outTime.get()) -> {
                Toast.makeText(view.context, "Please Select Out Time", Toast.LENGTH_SHORT).show()
            }
            else ->{
                view.context.startActivity(Intent(view.context, FeedbackFormActivity::class.java))
                feedGiven.set(true)
            }
        }

    }

    fun verifyServiceCompleted(view: View) {
        when {
            TextUtils.isEmpty(inTime.get()) -> {
                Toast.makeText(view.context, "Please Select In Time", Toast.LENGTH_SHORT).show()
            }
            TextUtils.isEmpty(outTime.get()) -> {
                Toast.makeText(view.context, "Please Select Out Time", Toast.LENGTH_SHORT).show()
            }
            else -> {
                //show otp dialog
                val dialog = Dialog(view.context)

                dialog.setContentView(R.layout.dialog_otp_verify)
                dialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
//                dialog.setCancelable(false);
                dialog.findViewById<Button>(R.id.btn_verify).setOnClickListener {
                    val pinView = dialog.findViewById<PinEntryEditText>(R.id.pin)
                    when {
                        TextUtils.isEmpty(pinView.text) -> {
                            Toast.makeText(view.context, "Please Enter OTP", Toast.LENGTH_SHORT)
                                .show()
                        }
                        pinView.text!!.length < 4 -> {
                            Toast.makeText(
                                view.context,
                                "Please Enter Valid OTP",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else -> {
                            isVerified.set(true)
                            dialog.dismiss()
                        }
                    }
                }

                dialog.show()


            }
        }
    }
}