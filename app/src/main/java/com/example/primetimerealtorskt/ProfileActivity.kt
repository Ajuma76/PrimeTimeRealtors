package com.example.primetimerealtorskt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class ProfileActivity : AppCompatActivity() {
    var imageIconHome: ImageView?=null
    var imageIconCategory: ImageView?=null
    var imageIconProfile: ImageView?=null

    var joinus:Button? = null
    var signin:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        imageIconHome = findViewById(R.id.mImgHomeIcon)
        imageIconCategory = findViewById(R.id.mImgCategoryIcon)
        imageIconProfile = findViewById(R.id.mImgProfileIcon)

        joinus = findViewById(R.id.join)
        signin = findViewById(R.id.signin)

        //set onclick listener

        joinus!!.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))

        }

        signin!!.setOnClickListener {
            startActivity(Intent(this,LoginActivity233::class.java))

        }





//navigation
        imageIconHome!!.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))

        }

        imageIconCategory!!.setOnClickListener {
            startActivity(Intent(this,CategoriesActivity2::class.java))
        }

        imageIconProfile!!.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
            finish()
        }
    }


}