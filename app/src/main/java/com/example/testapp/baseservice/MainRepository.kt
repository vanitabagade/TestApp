package com.example.testapp.baseservice

import com.example.testapp.baseservice.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllUsers() = retrofitService.getAllUsers()
}
