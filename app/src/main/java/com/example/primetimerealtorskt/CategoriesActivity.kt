package com.example.primetimerealtorskt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.primetimerealtorskt.adapter.ViewPagerAdapter
import com.example.primetimerealtorskt.model.ForsaleData
import com.example.primetimerealtorskt.model.TopPlacesData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.ArrayList

class CategoriesActivity : AppCompatActivity() {

    var imageIconHome: ImageView?=null
    var imageIconCategory: ImageView?=null
    var imageIconProfile: ImageView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        imageIconHome = findViewById(R.id.mImgHomeIcon)
        imageIconCategory = findViewById(R.id.mImgCategoryIcon)
        imageIconProfile = findViewById(R.id.mImgProfileIcon)


        //forsale



        //navigation
        imageIconHome!!.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        imageIconCategory!!.setOnClickListener {
            startActivity(Intent(this,CategoriesActivity::class.java))
        }

        imageIconProfile!!.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }

        val tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        val ViewPager2=findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter= ViewPagerAdapter(supportFragmentManager, lifecycle)

        ViewPager2.adapter=adapter

        TabLayoutMediator(tabLayout,ViewPager2){tab,position->
            when(position){
                0->{
                    tab.text="For Sale"
                }
                1->{
                    tab.text="Rentals"
                }
            }
        }.attach()

    }

}