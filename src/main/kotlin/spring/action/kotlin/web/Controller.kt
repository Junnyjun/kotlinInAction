package spring.action.kotlin.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import spring.action.kotlin.entity.Taco

@Controller
class Controller() {

    @GetMapping("/")
    fun home(): String {
        return "home";
    }
}