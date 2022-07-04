package spring.action.kotlin.web

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import spring.action.kotlin.db.user.UserRepository
import spring.action.kotlin.web.model.RegistrationForm


@Controller
@RequestMapping("/register")
class RegisterController(
    private val userRepo: UserRepository,
    private val passwordEncoder: PasswordEncoder
    ) {

    @GetMapping
    fun registerForm(): String {
        return "registration";
    }

    @PostMapping
    fun registerProcessing(form : RegistrationForm): String {
        userRepo.save(form.toUser(passwordEncoder))
        return "redirecdt:/login"
    }
}