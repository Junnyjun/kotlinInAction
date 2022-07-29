package spring.action.kotlin.web.model


import spring.action.kotlin.db.user.User


class RegistrationForm (
    private val username: String,
            private val password: String,
){
    fun toUser(): User {
        return User(username, password)
    }
}