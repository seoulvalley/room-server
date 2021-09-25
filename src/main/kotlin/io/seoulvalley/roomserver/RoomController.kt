package io.seoulvalley.roomserver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.ArrayList

@RestController
class RoomController(val roomRepository: RoomRepository) {
    @GetMapping("/rooms")
    fun getRooms(): Array<String> {
        val rooms: ArrayList<String> = ArrayList()
        roomRepository.findAll().forEach {
            rooms.add(it.roomID)
        }

        return rooms.toTypedArray()
    }

    data class RoomCreate(
        val peerAddress: String,
    )

    @PostMapping("/rooms")
    fun createRoom(@RequestBody roomCreate: RoomCreate) {
        roomRepository.save(
            Room(
                roomID = UUID.randomUUID().toString(),
                peer = roomCreate.peerAddress
            )
        )
    }
}