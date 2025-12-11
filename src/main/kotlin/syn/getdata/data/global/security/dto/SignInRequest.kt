package syn.getdata.data.global.security.dto

data class SignInRequest ( // data 클래스는 getter, setter 다 만들어줌.
    var loginId: String,
    var password: String
)