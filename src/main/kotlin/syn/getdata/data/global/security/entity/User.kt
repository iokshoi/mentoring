package kr.mooner510.getdata.global.security.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false, unique = true)
    var loginId: String,

    @Column(nullable = false)
    private var password: String,

    @Column(nullable = false)
    val nickname: String,

    @Column(nullable = true, unique = true)
    val email: String?,
): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> = emptyList()

    override fun getPassword(): String = this.password

    override fun getUsername(): String = this.loginId
}