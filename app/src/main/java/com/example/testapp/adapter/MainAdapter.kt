package com.example.testapp.adapter

import android.content.Context
import android.content.Intent

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.DetailActivity
import com.example.testapp.model.Item


import com.example.testapp.databinding.AdapterUserBinding

import java.util.*



class MainAdapter(private val context: Context): RecyclerView.Adapter<MainViewHolder>() {
    var users = mutableListOf<Item>()
    fun setMovieList(userlist: List<Item>) {
        //sort list
        Collections.sort(userlist
        ) { lhs, rhs -> lhs.display_name.compareTo(rhs.display_name) }
        this.users = userlist.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterUserBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = users[position]
       holder.binding.name.text = user.display_name
       holder.binding.tvUserid.text = user.user_id.toString()
        holder.itemView.setOnClickListener {

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("profile_pic",user.profile_image)
            intent.putExtra("user_name",user.display_name)
            intent.putExtra("reputation",user.reputation)
            intent.putExtra("Badges_bronze",user.badge_counts.bronze)
            intent.putExtra("Badges_silver",user.badge_counts.silver)
            intent.putExtra("Badges_gold",users[position].badge_counts.gold)
            intent.putExtra("location",user.location)
            intent.putExtra("creation_date",user.creation_date)
            context.startActivity(intent)


        }

    }
    override fun getItemCount(): Int {
        //limit 20 items
        val limit = 20
        return Math.min(users.size, limit)
        //return users.size
    }
}
class MainViewHolder(val binding: AdapterUserBinding) : RecyclerView.ViewHolder(binding.root) {
}