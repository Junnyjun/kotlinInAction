package spring.action.kotlin.db

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import spring.action.kotlin.entity.Ingredient

@Repository
interface IngredientRepository : JpaRepository<Ingredient, Long>