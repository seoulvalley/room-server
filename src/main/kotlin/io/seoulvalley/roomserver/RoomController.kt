package io.seoulvalley.roomserver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RoomController {
    @GetMapping("/")
    fun hello(): String {
        return "Hello World"
    }

    @GetMapping("/rooms")
    fun getMapping(): Array<String> {
        return arrayOf("1", "2")
    }
}