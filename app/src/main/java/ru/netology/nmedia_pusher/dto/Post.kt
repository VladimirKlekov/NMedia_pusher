package ru.netology.nmedia_pusher.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean,
    val likes: Long,
    val share:Long,
    var eye:Long,
    val video: String? = null

)