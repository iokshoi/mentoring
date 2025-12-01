package syn.getdata.data.domain.board.service

import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import syn.getdata.data.domain.board.dto.CreateBoardRequest
import syn.getdata.data.domain.board.dto.UpdateBoardRequest
import syn.getdata.data.domain.board.entity.Board
import syn.getdata.data.domain.board.repository.BoardRepository

@Service
class BoardService(private val boardRepository: BoardRepository) {
    fun getBoard(id: Long): Board {
        return boardRepository.findByIdOrNull(id) ?: throw NullPointerException("$id 의 아이디를 가진 Board를 찾지 못합니다.") // 찾지 못할경우 서버내 에러기 때문에 500
    }

    fun createBoard(request: CreateBoardRequest): Board {
        return boardRepository.save(Board(0, request.title, request.content, request.author)) // id를 0으로 설정해준다면 자동으로 알아서 설정해라! 즉, Entity의 GenerationType을 따를것.
    }

    fun deleteBoard(id: Long) {
        boardRepository.deleteById(id)
    }

    @Transactional
    fun updateBoard(id: Long, request: UpdateBoardRequest) {
        val board = this.getBoard(id)
        board.title = request.title
    }

    fun getAllBoards(): List<Board> {
        return boardRepository.findAll()
    }

    fun getBoardByTitle(query: String): List<Board> {
//        return boardRepository.findByTitleContainsOrContentContainsOrderByTitleAsc(title = query, content = query)
        return boardRepository.findByTitleContains(query)
    }
}