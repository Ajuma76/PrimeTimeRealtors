package com.example.primetimerealtorskt

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth


class Profile1Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        var buttonCall: ImageView? = null
        var buttonEmail: ImageView? = null
        var buttonShare: ImageView? = null
        var buttonLogout: ImageView? = null

        var imageIconHome: ImageView? = null
        var imageIconCategory: ImageView? = null
        var imageIconProfile: ImageView? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile1)

        buttonCall = findViewById(R.id.callbtn)
        buttonEmail = findViewById(R.id.emailbtn)
        buttonShare = findViewById(R.id.sharebtn)
        buttonLogout = findViewById(R.id.logoutbtn)

        imageIconHome = findViewById(R.id.mImgHomeIcon)
        imageIconCategory = findViewById(R.id.mImgCategoryIcon)
        imageIconProfile = findViewById(R.id.mImgProfileIcon)


        buttonCall!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0704617805"))
            if (ContextCompat.checkSelfPermission(
                    this@Profile1Activity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Profile1Activity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

        buttonEmail!!.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "Primetimerealtors@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Property Enquiry")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir,......")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        buttonShare!!.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)

        }

        buttonLogout!!.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this, LoginActivity233::class.java))
            finish()
        }



        imageIconHome!!.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }

        imageIconCategory!!.setOnClickListener {
            startActivity(Intent(this, CategoriesActivity2::class.java))
        }

        imageIconProfile!!.setOnClickListener {
            startActivity(Intent(this, Profile1Activity::class.java))
            finish()

        }




    }
}