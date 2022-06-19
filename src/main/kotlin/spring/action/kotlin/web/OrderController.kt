package spring.action.kotlin.web

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import spring.action.kotlin.entity.Order


@Controller
@RequestMapping("/orders")
class OrderController {
    private val log = LoggerFactory.getLogger(OrderController::class.java)

    @GetMapping("/current")
    fun orderForm(model: Model): String {
        model
            .addAttribute("order", Order())
            .also { log.info("/get 요청 실행") }
            .let { return "orderForm" }

    }

    @PostMapping
    fun processOrder(
        order: Order,
        errors: Errors
    ): String {
        return errors.takeIf { it.hasErrors() }
            ?.let { "orderForm" }
            ?: "redirect:/"
    }

}