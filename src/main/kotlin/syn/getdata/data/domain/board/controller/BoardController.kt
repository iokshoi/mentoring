package syn.getdata.data.domain.board.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import syn.getdata.data.domain.board.dto.CreateBoardRequest
import syn.getdata.data.domain.board.dto.UpdateBoardRequest
import syn.getdata.data.domain.board.entity.Board
import syn.getdata.data.domain.board.service.BoardService

@RestController
@RequestMapping("/board")
class BoardController(private val boardService: BoardService) {
    @PostMapping
    fun createBoard(@RequestBody request: CreateBoardRequest): Board {
        return boardService.createBoard(request)
    }

    @GetMapping
    fun getBoard(@RequestParam id: Long): Board {
        return boardService.getBoard(id)
    }

    @PutMapping
    fun updateBoard(@RequestParam id : Long, @RequestBody request: UpdateBoardRequest) {
        return boardService.updateBoard(id,request)
    }

    @DeleteMapping
    fun deleteBoard(@RequestParam id: Long) {
        return boardService.deleteBoard(id)
    }

    @GetMapping("/all")
    fun getAllBoards(): List<Board> { // 보드 Entity에 대하여 리스트로 반환.
        return boardService.getAllBoards()
    }

    @GetMapping("/search")
    fun getBoardByTitle(@RequestParam query: String): List<Board> {
        return boardService.getBoardByTitle(query = query)
    }
}