package ru.netology.nmedia_pusher.viewmodel

import android.app.Application
import androidx.lifecycle.*
import ru.netology.nmedia_pusher.db.AppDb
import ru.netology.nmedia_pusher.dto.Post
import ru.netology.nmedia_pusher.repository.PostRepository
import ru.netology.nmedia_pusher.repository.PostRepositoryImpl


private val empty = Post(
    id = 0,
    content = "",
    author = "",
    likedByMe = false,
    likes = 0,
    published = "",
    share = 0L,
    eye = 0L,


)

class PostViewModel(application: Application) : AndroidViewModel(application) {
    // упрощённый вариант
    private val repository: PostRepository = PostRepositoryImpl(
        AppDb.getInstance(context = application).postDao()
    )
    val data = repository.getAll()
    val edited = MutableLiveData(empty)

    fun save() {
        edited.value?.let {
            repository.save(it)
        }
        edited.value = empty
    }

    fun edit(post: Post) {
        edited.value = post
    }

    fun changeContent(content: String) {
        val text = content.trim()
        if (edited.value?.content == text) {
            return
        }
        edited.value = edited.value?.copy(content = text)
    }

    fun likeById(id: Long) = repository.likeById(id)
    fun removeById(id: Long) = repository.removeById(id)
}