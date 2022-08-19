package ru.netology.nmedia_pusher.repository

import androidx.lifecycle.LiveData
import ru.netology.nmedia_pusher.dto.Post


interface PostRepository {
    fun getAll(): LiveData<List<Post>>
    fun likeById(id: Long)
    fun save(post: Post)
    fun removeById(id: Long)
}