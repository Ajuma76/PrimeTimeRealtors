package com.example.primetimerealtorskt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class SignupActivity : AppCompatActivity() {
    var name: EditText? = null
    var email: EditText? = null
    var password: EditText? = null
    var phone: EditText? = null
    var register: Button? = null
    var already: TextView? = null
    var fAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        name = findViewById(R.id.fname)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password10)
        phone = findViewById(R.id.phone10)
        register = findViewById(R.id.register)
        already = findViewById(R.id.already)
        fAuth = FirebaseAuth.getInstance()

        val user = fAuth!!.currentUser
        if (user != null) {
            // User is signed in
            val intent = Intent(this, MainActivity::class.java)

        }


        //set the onclick listener

        register!!.setOnClickListener {
            // start receiving data from user
            var name = name!!.text.toString().trim()
            var email = email!!.text.toString().trim()
            var password = password!!.text.toString().trim()
            var phone = phone!!.text.toString().trim()

            // check if user is entering empty fields

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()

            }
            if (password.length < 6) {
                Toast.makeText(this, "Password must be >=6 characters", Toast.LENGTH_LONG).show()
            }

            //register the user in firebase

            fAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    //firebase registered user
                    val firebaseUser = fAuth!!.currentUser

                    Toast.makeText(this, "User created successfully", Toast.LENGTH_LONG).show()

                    //redirect user to main activity
                    fAuth!!.signOut()
                    val intent = Intent(this, LoginActivity233::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    intent.putExtra("user_id", firebaseUser!!.uid)
                    intent.putExtra("email_id", email)
                    startActivity(intent)
                    finish()
                } else {
                    //if the registration is not successful, show error message
                    Toast.makeText(this, task.exception!!.toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
        already!!.setOnClickListener {
            val intent = Intent(this, LoginActivity233::class.java)
            startActivity(intent)

        }
    }

}
