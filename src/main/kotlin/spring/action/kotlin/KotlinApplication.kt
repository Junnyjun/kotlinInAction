package spring.action.kotlin

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import spring.action.kotlin.db.IngredientRepository
import spring.action.kotlin.entity.Ingredient

@SpringBootApplication
class KotlinApplication{
    fun main(args: Array<String>) {
        runApplication<KotlinApplication>(*args)


    }

    @Bean
    fun dataLoader(repo : IngredientRepository) =  CommandLineRunner {
        repo.saveAll(listOf(
            Ingredient("FLTO", "FLOUR TORTILLA", Ingredient.Type.WRAP),
            Ingredient("COTO", "CORN TORTILLA", Ingredient.Type.WRAP),
            Ingredient("GRBF", "GROUND BEEF", Ingredient.Type.WRAP)
        ))

    }
}


