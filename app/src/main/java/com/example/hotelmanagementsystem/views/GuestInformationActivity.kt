package com.example.hotelmanagementsystem.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.hotelmanagementsystem.R
import com.example.hotelmanagementsystem.model.Customer
import com.example.hotelmanagementsystem.model.PersonalInfo
import com.example.hotelmanagementsystem.utils.DynamicTextWatcher
import com.example.hotelmanagementsystem.utils.General


//implements ,AdapterView.OnItemSelectedListener
class GuestInformationActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    private lateinit var title:String
    private lateinit var gender:String
    private lateinit var firstName:EditText
    private lateinit var lastName:EditText
    private lateinit var initial:EditText
    private lateinit var email:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_information)

        val moveToAddress: Button = findViewById<Button>(R.id.btn_move_to_address)
        val spinnerTitle: Spinner = findViewById<Spinner>(R.id.spinner_title)
        val spinnerGender: Spinner = findViewById<Spinner>(R.id.spinner_gender)
        firstName = findViewById(R.id.edt_first_name)
        lastName = findViewById(R.id.edt_last_name)
        initial = findViewById(R.id.edt_middle_initial)
        email = findViewById(R.id.edt_email)

        firstName.addTextChangedListener(DynamicTextWatcher())
        lastName.addTextChangedListener(DynamicTextWatcher())
        initial.addTextChangedListener(DynamicTextWatcher())
        email.addTextChangedListener(DynamicTextWatcher())


        General.setAdapter(spinnerTitle, R.array.title, this)
        General.setAdapter(spinnerGender, R.array.gender, this)
        spinnerTitle.onItemSelectedListener = this
        spinnerGender.onItemSelectedListener = this


        // button onclick listener
        moveToAddress.setOnClickListener{

            val isValidFirstName = DynamicTextWatcher.isValidTextField(firstName)
            val isValidLastName = DynamicTextWatcher.isValidTextField(lastName)
            val isValidInitial = DynamicTextWatcher.isValidTextField(initial)
            val isValidEmail = DynamicTextWatcher.isValidTextField(email)

            if(isValidEmail && isValidFirstName && isValidInitial && isValidEmail && isValidLastName){
                val personalInfo:PersonalInfo = PersonalInfo(
                    firstName = firstName.text.toString(),
                    lastName = lastName.text.toString(),
                    inits = initial.text.toString(),
                    emailAddress = email.text.toString(),
                    title = title,
                    gender = gender
                )
                Customer.personalInfo = personalInfo
                Toast.makeText(this, personalInfo.toString(), Toast.LENGTH_LONG).show()
                val intent = Intent(this, GuestInformationActivity2::class.java)
                startActivity(intent)
            }
        }
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val itemText = parent?.getItemAtPosition(position).toString().lowercase()
        if(itemText == "male" || itemText == "female"){
            gender = itemText
        } else {
            title = itemText
        }
    }



    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}