package com.example.testapp.model

data class UserModel(
    val backoff: Int,
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)