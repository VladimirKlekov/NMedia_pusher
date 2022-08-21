package ru.netology.nmedia_pusher.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.nmedia_pusher.dto.Post


@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean,
    val likes: Long,
    val share:Long,
    var eye:Long,
    val video: String? = null
) {
    fun toDto() = Post(id, author, content, published, likedByMe, likes, share,eye)

    companion object {
        fun fromDto(dto: Post) =
            PostEntity(dto.id, dto.author, dto.content, dto.published, dto.likedByMe, dto.likes, dto.share, dto.eye)

    }
}