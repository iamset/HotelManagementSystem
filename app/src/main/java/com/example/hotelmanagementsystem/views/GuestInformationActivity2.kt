package com.example.hotelmanagementsystem.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.Toast.*
import com.example.hotelmanagementsystem.R
import com.example.hotelmanagementsystem.model.Address
import com.example.hotelmanagementsystem.model.Customer
import com.example.hotelmanagementsystem.utils.DynamicTextWatcher
import com.example.hotelmanagementsystem.utils.General

class GuestInformationActivity2 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var country:String
    private lateinit var companyName:EditText
    private lateinit var address:EditText
    private lateinit var city:EditText
    private lateinit var postalCode:EditText
    private lateinit var dayTimePhone:EditText
    private lateinit var mobilePhone:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_information2)

        val moveToAdditionalDetails:Button = findViewById(R.id.btn_move_to_additional_details)
        val spinnerCountry:Spinner = findViewById(R.id.spinner_country)
        companyName = findViewById(R.id.edt_company_name)
        address = findViewById(R.id.edt_address)
        city = findViewById(R.id.edt_city)
        postalCode = findViewById(R.id.edt_postal_code)
        dayTimePhone = findViewById(R.id.edt_daytime_phone)
        mobilePhone = findViewById(R.id.edt_mobile_phone)


        General.setAdapter(spinnerCountry, R.array.country, this)
        spinnerCountry.onItemSelectedListener = this
        companyName.addTextChangedListener(DynamicTextWatcher())
        address.addTextChangedListener(DynamicTextWatcher())
        city.addTextChangedListener(DynamicTextWatcher())
        postalCode.addTextChangedListener(DynamicTextWatcher())
        dayTimePhone.addTextChangedListener(DynamicTextWatcher())
        mobilePhone.addTextChangedListener(DynamicTextWatcher())

        // on click listener
        moveToAdditionalDetails.setOnClickListener{

            val isValidCompanyName = DynamicTextWatcher.isValidTextField(companyName)
            val isValidAddress = DynamicTextWatcher.isValidTextField(address)
            val isValidCity = DynamicTextWatcher.isValidTextField(city)
            val isValidPostalCode = DynamicTextWatcher.isValidTextField(postalCode)
            val isValidDayTimePhone = DynamicTextWatcher.isValidTextField(dayTimePhone)
            val isValidMobilePhone = DynamicTextWatcher.isValidTextField(mobilePhone)

            if(isValidAddress && isValidCompanyName && isValidCity && isValidPostalCode
                && isValidDayTimePhone && isValidMobilePhone
            ){
                val address: Address = Address(
                    companyName = companyName.text.toString(),
                    address = address.text.toString(),
                    city = city.text.toString(),
                    postalCode = postalCode.text.toString(),
                    dayTimePhone = dayTimePhone.text.toString(),
                    mobilePhone = mobilePhone.text.toString(),
                    country = country
                )
                Toast.makeText(this, address.toString(), Toast.LENGTH_LONG).show()
                Customer.address = address
                val intent = Intent(this, GuestInformationActivity3::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val itemText = parent?.getItemAtPosition(position).toString().lowercase()
        country = itemText
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}