package io.seoulvalley.roomserver

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository: CrudRepository<Room, String>