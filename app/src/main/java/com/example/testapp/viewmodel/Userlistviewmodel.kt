package com.example.testapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.baseservice.MainRepository
import com.example.testapp.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Userlistviewmodel constructor(private val repository: MainRepository)  : ViewModel() {

    val userList = MutableLiveData<UserModel>()
    val errorMessage = MutableLiveData<String>()

    fun getAllUsers() {
        val response = repository.getAllUsers()
        response.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                Log.d("response", "Total Questions: " + response.body()!!.items!!.size)

                userList.postValue(response.body())
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}