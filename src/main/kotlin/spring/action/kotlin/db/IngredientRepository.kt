package spring.action.kotlin.db

import org.springframework.data.repository.CrudRepository
import spring.action.kotlin.entity.Ingredient

interface IngredientRepository : CrudRepository<String, Ingredient> {
    fun saveAll(ingredients: List<Ingredient>)
}