package syn.getdata.data.domain.board.dto

data class CreateBoardRequest(
    val title: String,
    val content: String,
    val author: String,
)
