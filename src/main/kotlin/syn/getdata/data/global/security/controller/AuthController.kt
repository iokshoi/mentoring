package kr.mooner510.getdata.global.security.controller

import kr.mooner510.getdata.global.security.dto.TokenResponse
import kr.mooner510.getdata.global.security.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import syn.getdata.data.global.security.dto.SignInRequest
import syn.getdata.data.global.security.dto.SignUpRequest

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {
    // 로그인
    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInRequest: SignInRequest): TokenResponse {
        return authService.signIn(signInRequest)
    }

    // 회원가입
    @PostMapping("/sign-up")
    fun signUp(@RequestBody singUpRequest: SignUpRequest) {
        return authService.signUp(singUpRequest)
    }
}