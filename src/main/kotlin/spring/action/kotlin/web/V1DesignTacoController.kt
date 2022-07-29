package spring.action.kotlin.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import spring.action.kotlin.db.ingredient.Ingredient
import spring.action.kotlin.db.ingredient.Type
import spring.action.kotlin.db.ingredient.Type.WRAP
import spring.action.kotlin.entity.Taco


@Controller
@RequestMapping("/v1/design")
class V1DesignTacoController {

    @GetMapping
    fun showDesignFrom(model: Model): String {
        val ingredients = listOf(
            Ingredient("FLTO", "FLOUR TORTILLA", WRAP),
            Ingredient("COTO", "CORN TORTILLA", WRAP),
            Ingredient("GRBF", "GROUND BEEF", WRAP)
        )

        for (value in Type.values()) {
            model
                .addAttribute(value.toString().lowercase(), ingredients.filter { it.type == value })
                .addAttribute("taco", Taco())
        }

        return "design"
    }

    @PostMapping
    fun processDesign(design:  Taco, errors: Errors): String {
        return errors.takeIf { it.hasErrors() }
            ?.let { "design" }
            ?: "redirect:/orders/current"
    }

    private fun filterByType(
        ingredients : List<Ingredient> ,
        type : Type
    ) : List<Ingredient>{
        return ingredients.filter{ it.type == type }
    }
}