package com.example.hotelmanagementsystem.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.hotelmanagementsystem.R
import com.example.hotelmanagementsystem.model.AdditionalDetails
import com.example.hotelmanagementsystem.model.Customer
import com.example.hotelmanagementsystem.utils.DynamicTextWatcher

class GuestInformationActivity3 : AppCompatActivity() {
    private var business:Boolean = false
    private var leisure: Boolean = false
    lateinit var comment: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_information3)

        val button: Button = findViewById(R.id.btn_save_guest_details)
        val comment = findViewById<EditText>(R.id.edt_comment)

        comment.addTextChangedListener(DynamicTextWatcher())
        button.setOnClickListener{

            val isValidComment = DynamicTextWatcher.isValidTextField(comment)
            if(isValidComment){
                val additionalDetails: AdditionalDetails = AdditionalDetails(
                    reasonForVisit = if(business) "business" else "leisure",
                    comments = comment.text.toString()
                )
                Customer.additionalDetails = additionalDetails
                val intent:Intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
            }

        }
    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rb_business ->
                    if (checked) {
                        business = true
                    }
                R.id.rb_leisure ->
                    if (checked) {
                        leisure = true
                    }
            }
        }
    }
}