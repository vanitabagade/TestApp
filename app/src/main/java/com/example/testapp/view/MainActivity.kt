package com.example.testapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.adapter.MainAdapter
import com.example.testapp.baseservice.MainRepository
import com.example.testapp.baseservice.RetrofitService
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.viewmodel.Userlistviewmodel
import com.example.testapp.viewmodel.UserlistviewmodelFactory
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: Userlistviewmodel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, UserlistviewmodelFactory(MainRepository(retrofitService))).get(Userlistviewmodel::class.java)
        binding.rvUsers.adapter = adapter

        viewModel.userList.observe(this, Observer {

            Log.d(TAG, "onCreate: $it")

            adapter.setMovieList(it.items)
        })
        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllUsers()


    }


}