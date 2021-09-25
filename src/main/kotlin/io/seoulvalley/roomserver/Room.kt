package io.seoulvalley.roomserver

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash("Rooms")
data class Room(
    @Indexed
    @Id
    val roomID: String,
    val peer: String,
) {
}