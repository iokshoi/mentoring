package kr.mooner510.getdata.global.security.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import kr.mooner510.getdata.global.security.dto.TokenResponse
import kr.mooner510.getdata.global.security.entity.User
import kr.mooner510.getdata.global.security.repository.UserRepository
import org.apache.coyote.BadRequestException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import syn.getdata.data.global.security.dto.SignInRequest
import syn.getdata.data.global.security.dto.SignUpRequest
import java.time.Instant
import java.util.Date
import kotlin.jvm.optionals.getOrNull

@Service
class AuthService(private val userRepository: UserRepository) {
    private val passwordEncoder = BCryptPasswordEncoder() // password 암호화
    private val privateKey = "대덕소프트웨어마이스터고등학교"

    private val key = Keys.hmacShaKeyFor(privateKey.toByteArray()) // 만듦
    private val parser = Jwts.parser().verifyWith(key).build() // 실제로 쓰겠다!

    fun signIn(signInRequest: SignInRequest): TokenResponse {
        // 로그인 틀림 오류
        val user = userRepository.findByLoginId(signInRequest.loginId).getOrNull() ?: throw NullPointerException()

        if (passwordEncoder.matches(user.password, signInRequest.password)) {
            val token = Jwts.builder()
                .id(user.id.toString())
                .subject("user")
                .claim("nickname", user.nickname)
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusSeconds(3600)))
                .signWith(key)
                .compact()

            return TokenResponse(token)
        }

        // 유저 아님 오류
        throw NullPointerException()
    }

    fun signUp(signUpRequest: SignUpRequest) {
        if (userRepository.existsByLoginIdIgnoreCase(signUpRequest.loginId)) {
            // 로그인 이미 있음!!
            throw BadRequestException("이미 있는 ID입니다!")
        }

        userRepository.save(User(0, signUpRequest.loginId, passwordEncoder.encode(signUpRequest.password), signUpRequest.nickname, signUpRequest.email))
    }
}