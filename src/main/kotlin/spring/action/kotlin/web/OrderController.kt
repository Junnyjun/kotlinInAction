package spring.action.kotlin.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import spring.action.kotlin.entity.Order


@Controller
@RequestMapping("/orders")
class OrderController {

    @GetMapping
    fun orderForm(model : Model) : String{
        model.addAttribute("order", Order())
        return "orderForm"
    }

    @PostMapping
    fun processOrder(order: Order) : String{
        return "redirect:/"
    }
}