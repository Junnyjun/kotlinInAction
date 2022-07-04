package spring.action.kotlin.db.ingredient

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
sealed interface IngredientRepository : JpaRepository<Ingredient, Long>