package com.testing.courselab1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainClassList : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)

        val swDegreeCert = findViewById<Switch>(R.id.swDegreeCert)
        val spnDegree = findViewById<Spinner>(R.id.spnDegree)
        val spnCertificate = findViewById<Spinner>(R.id.spnCertificate)
        val txtCertificate = findViewById<TextView>(R.id.lblCertificate)
        val txtDegree = findViewById<TextView>(R.id.lblDegree)
        val btnNext = findViewById<Button>(R.id.btnNextMain)

        val firstName = findViewById<EditText>(R.id.idFirstName)
        val lastName = findViewById<EditText>(R.id.idLastName)
        val phone = findViewById<EditText>(R.id.idPhone)

        val spnMonth = findViewById<Spinner>(R.id.idMonth)
        val txtDay = findViewById<EditText>(R.id.idDay)
        val txtYear = findViewById<EditText>(R.id.idYear)

        firstName.requestFocus()
        swDegreeCert.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                spnDegree.visibility = View.VISIBLE
                txtDegree.visibility = View.VISIBLE
                spnCertificate.visibility = View.GONE
                txtCertificate.visibility = View.GONE

            } else {
                spnDegree.visibility = View.GONE
                txtDegree.visibility = View.GONE
                spnCertificate.visibility = View.VISIBLE
                txtCertificate.visibility = View.VISIBLE
            }
        }

        btnNext.setOnClickListener {
            if (checkData()) {
                var doBirth = ""
                doBirth =
                    spnMonth.selectedItem.toString() + "/" + txtDay.text.toString() + "/" + txtYear.text.toString()

                val nextScreen = Intent(this@MainClassList, ChooseClass::class.java)
                nextScreen.putExtra("FirstName", firstName.text.toString())
                nextScreen.putExtra("LastName", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("Birthdate", doBirth)

                if (spnDegree.visibility == View.VISIBLE) {
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("degreeCert", spnDegree.selectedItem.toString())
                } else {
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("degreeCert", spnCertificate.selectedItem.toString())
                }
                // Start Activity
                startActivity(nextScreen)
            }
        }
    }
            private fun checkData(): Boolean {
                val firstName = findViewById<EditText>(R.id.idFirstName)
                val lastName = findViewById<EditText>(R.id.idLastName)
                val phone = findViewById<EditText>(R.id.idPhone)

                val txtDay = findViewById<EditText>(R.id.idDay)
                val txtYear = findViewById<EditText>(R.id.idYear)
                if (firstName.text.toString().isEmpty()) {
                    //error
                    firstName.error = "Invalid First Name"
                    firstName.requestFocus()
                    return false
                }
                if (lastName.text.toString().isEmpty()) {
                    //error
                    lastName.error = "Invalid Last Name"
                    lastName.requestFocus()
                    return false
                }
                if (phone.text.toString().isEmpty()) {
                    //error
                    phone.error = "Invalid phone"
                    phone.requestFocus()
                    return false
                }
                if (txtDay.text.toString().isEmpty()) {
                    //error
                    txtDay.error = "Invalid txtDay"
                    txtDay.requestFocus()
                    return false
                }
                if (txtYear.text.toString().isEmpty()) {
                    //error
                    txtYear.error = "Invalid txtYear"
                    txtYear.requestFocus()
                    return false
                }
                return true
            }


//        val extras = intent.extras
//        if (extras !=null){
//            var firstName = extras.getString("FirstName")
//            var lastName = extras.getString("LastName")
//            var phone = extras.getString("Phone")
//            var birthDate = extras.getString("BirthDate")
//            var isDegreeCert = extras.getString("IsDegreeCert")
//            var degreeCert = extras.getString("DegreeCert")
//            var class1 = extras.getString("Class1")
//            var selected1 = extras.getString("Selected1")
//            var class2 = extras.getString("Class2")
//            var selected2 = extras.getString("Selected2")
//            var class3 = extras.getString("Class3")
//            var selected3 = extras.getString("Selected3")
//            var class4 = extras.getString("Class4")
//            var selected4 = extras.getString("Selected4")
//        }
//    }
}