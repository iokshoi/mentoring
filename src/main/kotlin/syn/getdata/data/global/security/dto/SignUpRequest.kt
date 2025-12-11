package syn.getdata.data.global.security.dto

data class SignUpRequest(
    val nickname: String,
    val password: String,
    val email: String,
    val loginId: String
)