package syn.getdata.data.domain.board.repository

import org.springframework.data.jpa.repository.JpaRepository
import syn.getdata.data.domain.board.entity.Board

interface BoardRepository : JpaRepository<Board, Long> { // entity, id 타입
//    fun findByTitleContainsOrContentContainsOrderByTitleAsc(title: String, content: String): List<Board>
    fun findByTitleContains(title: String): List<Board>
}