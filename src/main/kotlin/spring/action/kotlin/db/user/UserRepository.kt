package spring.action.kotlin.db.user

import org.springframework.data.repository.CrudRepository

sealed interface UserRepository: CrudRepository<User, Long> {}