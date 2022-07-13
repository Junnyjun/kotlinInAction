package spring.action.kotlin.db.user

import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
    fun findByUserName(username:String): User
}