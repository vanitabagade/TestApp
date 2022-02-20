package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.example.testapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        //retrieve the data from intent
        var profilepic=intent.extras!!.get("profile_pic")
        var username="Username:"+"   "+intent.extras!!.get("user_name")
        var reputation="Reputation:"+"   "+intent.extras!!.get("reputation")
        var badges_silver="Silver:"+"   "+intent.extras!!.get("Badges_silver")
        var badges_gold="Gold"+"   "+intent.extras!!.get("Badges_gold")
        var badges_bronze="Bronze"+"   "+intent.extras!!.get("Badges_bronze")
        var location="Location:"+"   "+intent.extras!!.get("location")
        var creationdate="Creation date:"+"   "+intent.extras!!.get("creation_date")

        //bind data to views
        binding.tvUsername.text= intent.extras!!.get("user_name").toString()
        binding.tvUname.text= username
        binding.tvReputation.text= reputation
        binding.tvBadgesSilver.text= badges_silver
        binding.tvBadgesGold.text= badges_gold
        binding.tvBadgesBronze.text= badges_bronze
        binding.tvLocation.text= location
        binding.tvCreationdate.text= creationdate
        Glide.with(this)
            .load(profilepic)
            .into(binding.ivProfilepic)
        binding.ivBack.setOnClickListener {
            finish()
        }
    }


}
//Glide module
@GlideModule
class MyAppGlideModule : AppGlideModule() {
    // leave empty for now
}