package spring.action.kotlin.web.model


import org.springframework.security.crypto.password.PasswordEncoder
import spring.action.kotlin.db.user.User


class RegistrationForm (
    private val username: String,
            private val password: String,
){
    fun toUser(passwordEncoder: PasswordEncoder): User {
        return User(username, passwordEncoder.encode(password))
    }
}