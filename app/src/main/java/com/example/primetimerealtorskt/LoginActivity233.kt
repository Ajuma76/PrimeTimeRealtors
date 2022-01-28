package com.example.primetimerealtorskt

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class LoginActivity233 : AppCompatActivity() {
    var email: EditText? = null
    var password: EditText? = null
    var login: Button? = null
    var register10: TextView? = null
    var mAuth:FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login233)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password10)
        login = findViewById(R.id.login10)
        register10 = findViewById(R.id.already)
        var progress: ProgressDialog = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")

        mAuth = FirebaseAuth.getInstance();

        //set onclick listeners

        login!!.setOnClickListener {
            var email1=email!!.text.toString().trim()
            var password1=password!!.text.toString().trim()

            //check empty fields

            if (email1.isEmpty() || password1.isEmpty()){
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }

            //log in using firebase Auth
            progress.show()
            mAuth!!.signInWithEmailAndPassword(email1, password1).addOnCompleteListener { task->
                progress.dismiss()
                if (task.isSuccessful){
                    Toast.makeText(this, "You're logged in successfully", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, Profile1Activity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                    intent.putExtra("email_id", email1)
                    startActivity(intent)
                    finish()
                }else{
                    //if the log in is not successful, show error message
                    Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
        register10!!.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }
    }

}