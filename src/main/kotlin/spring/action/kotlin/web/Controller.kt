package spring.action.kotlin.web

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Controller {
    val log = LoggerFactory.getLogger(javaClass);

    @GetMapping("/")
    fun home(): String {
        log.info("HELLO")
        return "home";
    }

}