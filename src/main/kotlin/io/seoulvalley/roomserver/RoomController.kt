package io.seoulvalley.roomserver

import org.springframework.web.bind.annotation.*
import java.util.*

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
                peers = mutableListOf(roomCreate.peerAddress)
            )
        )
    }

    @GetMapping("/rooms/{roomID}")
    fun getRoom(@PathVariable roomID: String): Optional<Room> {
        return roomRepository.findById(roomID)
    }

    data class RoomJoin(
        val peerAddress: String
    )

    @PutMapping("/rooms/{roomID}")
    fun joinRoom(@PathVariable roomID: String, @RequestBody roomJoin: RoomJoin) {
        val room = roomRepository.findById(roomID).get()

        room.peers.add(roomJoin.peerAddress)

        roomRepository.save(room)
    }

}