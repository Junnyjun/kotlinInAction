package spring.action.kotlin.db.user

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(
    private val userRepository: UserRepository
) :UserDetailsService{
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUserName(username)
            ?: throw UsernameNotFoundException("NOT FOUND");
    }
}