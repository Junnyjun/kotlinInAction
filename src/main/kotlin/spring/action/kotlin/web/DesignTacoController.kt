package spring.action.kotlin.web

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import spring.action.kotlin.entity.Ingredient
import spring.action.kotlin.entity.Ingredient.Type
import spring.action.kotlin.entity.Ingredient.Type.WRAP
import spring.action.kotlin.entity.Ingredient.Type.values
import spring.action.kotlin.entity.Taco


@Slf4j
@Controller
@RequestMapping("/design")
class DesignTacoController {

    @GetMapping
    fun showDesignFrom(model : Model): String {
        var ingredients: MutableList<Ingredient> = mutableListOf()
        ingredients.add(Ingredient("FLTO", "FLOUR TORTILLA", WRAP))
        ingredients.add(Ingredient("COTO", "CORN TORTILLA", WRAP))
        ingredients.add(Ingredient("GRBF", "GROUND BEEF", WRAP))

        values().forEach { value -> model.addAttribute(value.toString().lowercase(), filterByType(ingredients, value)) }
        model.addAttribute("taco", Taco())

        return "design"
    }

    @PostMapping
    fun processDesign(design : Taco) : String{
        return "redirect:/orders/current"
    }

    private fun filterByType(
        ingredients : List<Ingredient> ,
        type : Type
    ) : List<Ingredient>{
        return ingredients.filter{ it.type == type }
    }
}