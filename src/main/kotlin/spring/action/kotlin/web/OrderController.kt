package spring.action.kotlin.web

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import spring.action.kotlin.entity.Order
import javax.validation.Valid


@Controller
@RequestMapping("/orders")
class OrderController {
    private val log = LoggerFactory.getLogger(OrderController::class.java)

    @GetMapping("/current")
    fun orderForm(model : Model) : String{
        model.addAttribute("order", Order())
        return "orderForm"
    }

    @PostMapping
    fun processOrder(order:@Valid Order,
                     errors: Errors) : String{
        if(errors.hasErrors()){
            return "orderForm"
        }

        log.info(order.toString())
        return "redirect:/"
    }


}