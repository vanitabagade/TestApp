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
        var username="Username"+"   "+intent.extras!!.get("user_name")
        var reputation="Reputation"+"   "+intent.extras!!.get("reputation")
        var toptags=intent.extras!!.get("reputation")
        var badges_silver="Silver"+"   "+intent.extras!!.get("Badges_silver")
        var badges_gold="Gold"+"   "+intent.extras!!.get("Badges_gold")
        var badges_bronze="Bronze"+"   "+intent.extras!!.get("Badges_bronze")
        var location="Location"+"   "+intent.extras!!.get("location")
        var creationdate="Creation date"+"   "+intent.extras!!.get("creation_date")

        //bind data to views
        binding.tvUname.text= username.toString()
        binding.tvReputation.text= reputation.toString()
        binding.tvToptags.text= username.toString()
        binding.tvBadgesSilver.text= badges_silver.toString()
        binding.tvBadgesGold.text= badges_gold.toString()
        binding.tvBadgesBronze.text= badges_bronze.toString()
        binding.tvLocation.text= location.toString()
        binding.tvCreationdate.text= creationdate.toString()
        Glide.with(this)
            .load(profilepic)
            .into(binding.ivProfilepic)

    }


}
//Glide module
@GlideModule
class MyAppGlideModule : AppGlideModule() {
    // leave empty for now
}