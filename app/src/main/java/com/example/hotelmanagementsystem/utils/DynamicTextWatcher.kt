package com.example.hotelmanagementsystem.utils

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText
import com.example.hotelmanagementsystem.R


class DynamicTextWatcher():TextWatcher {

    companion object{
        fun isValidTextField(field: EditText):Boolean{
            when(field.id){
                R.id.edt_first_name, R.id.edt_last_name, R.id.edt_company_name,
                R.id.edt_address, R.id.edt_city, R.id.edt_postal_code,
                R.id.edt_comment
                -> {
                    if(field.text.toString().length < 2){
                        field.requestFocus()
                        field.error = "Value must be greater than or equal to 2 characters."
                        return false
                    }
                    return true
                }
                R.id.edt_middle_initial-> {
                    if(field.text.toString().length != 1){
                        field.requestFocus()
                        field.error = "Initial must be a single character."
                        return false
                    }
                    return true
                }
                R.id.edt_email -> {
                    if(!Patterns.EMAIL_ADDRESS.matcher(field.text.toString()).matches()){
                        field.requestFocus()
                        field.error = "Enter a valid email address"
                        return false
                    }
                    return true
                }
                R.id.edt_mobile_phone, R.id.edt_daytime_phone -> {
                    if(!Patterns.PHONE.matcher(field.text.toString()).matches()){
                        field.requestFocus()
                        field.error = "Enter a valid phone number"
                        return false
                    }
                    return true
                }

                else -> return false
            }
        }
    }


    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable?) {

    }
}


