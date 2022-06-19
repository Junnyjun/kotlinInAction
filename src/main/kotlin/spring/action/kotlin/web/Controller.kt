package spring.action.kotlin.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Controller() {

    @GetMapping("/")
    fun home(): String {
        return "home";
    }
}