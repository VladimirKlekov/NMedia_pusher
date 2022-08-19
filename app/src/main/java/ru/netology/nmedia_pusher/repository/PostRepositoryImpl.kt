package ru.netology.nmedia_pusher.repository

import androidx.lifecycle.Transformations
import ru.netology.nmedia_pusher.dao.PostDao
import ru.netology.nmedia_pusher.dto.Post
import ru.netology.nmedia_pusher.entity.PostEntity


class PostRepositoryImpl(
    private val dao: PostDao,
) : PostRepository {
    override fun getAll() = Transformations.map(dao.getAll()) { list ->
        list.map {
            it.toDto()
        }
    }

    override fun likeById(id: Long) {
        dao.likeById(id)
    }

    override fun save(post: Post) {
        dao.save(PostEntity.fromDto(post))
    }

    override fun removeById(id: Long) {
        dao.removeById(id)
    }
}