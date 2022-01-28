package com.example.primetimerealtorskt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity2 : AppCompatActivity() {
    var mImgPlaceBanner:ImageView?=null
    var mImgBack:ImageView?=null
    var mTxTPlaceName:TextView?=null
    var mPrice:TextView?=null
    var mprice1:TextView?=null
    var mAvailable:TextView? = null
    var mDays:TextView? = null
    var mGallery:TextView? = null
    var like:ImageView? = null
    var sitting22:ImageView? = null
    var bedroom1:ImageView? = null
    var kitchen1:ImageView? = null
    var about1:TextView? = null
    var description:TextView? = null
    var buynow:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var placeImage= intent.getStringExtra("placeImage")
        var placeName= intent.getStringExtra("placeName")
        var countyName= intent.getStringExtra("countyName")
        var price= intent.getStringExtra("price")

        mImgPlaceBanner = findViewById(R.id.karen)
        mImgBack = findViewById(R.id.imageView3)
        mTxTPlaceName = findViewById(R.id.textView2)
        mPrice = findViewById(R.id.price22)
        mprice1 = findViewById(R.id.price23)
        mAvailable = findViewById(R.id.available)
        mDays = findViewById(R.id.days)
        mGallery = findViewById(R.id.gallery)
        sitting22 = findViewById(R.id.sitting22)
        bedroom1 = findViewById(R.id.bedroom)
        kitchen1 = findViewById(R.id.kitchen)
        about1 = findViewById(R.id.about2)
        description = findViewById(R.id.description34)
        buynow = findViewById(R.id.buy_now)
        like = findViewById(R.id.like)

        mImgPlaceBanner!!.setImageResource(placeImage!!.toInt())
        mTxTPlaceName!!.text = placeName+" "+countyName
        mPrice!!.text = "Price:"
        mprice1!!.text = price



    }
}