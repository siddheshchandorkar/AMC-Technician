package com.amc.feedback.presentation

import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.gcacace.signaturepad.views.SignaturePad

class FeedBackFormViewModel : ViewModel() {

    var isExpenses = MutableLiveData(false)
    var material1 = MutableLiveData("")
    var material2 = MutableLiveData("")
    var submit = MutableLiveData(false)
    var clearSignature = MutableLiveData(false)
    var isSigned = MutableLiveData(false)
    var saveSignature = MutableLiveData(false)

    val signatureListener =object : SignaturePad.OnSignedListener{
        override fun onStartSigning() {
            isSigned.value=true

        }

        override fun onSigned() {
            isSigned.value=true
        }

        override fun onClear() {
            isSigned.value=false
        }

    }

    fun onClearSignature(view: View) {
        clearSignature.value = true
    }

    fun submitFeedback(view: View) {
        if (isExpenses.value!!) {
            when {
                TextUtils.isEmpty(material1.value) -> {
                    Toast.makeText(
                        view.context,
                        "Please enter quantity for Material 1",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(material2.value) -> {
                    Toast.makeText(
                        view.context,
                        "Please enter quantity for Material 2",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                !isSigned.value!!->{
                    Toast.makeText(
                        view.context,
                        "Please Take Customer Signature",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        } else {
            when{
                !isSigned.value!!->{
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