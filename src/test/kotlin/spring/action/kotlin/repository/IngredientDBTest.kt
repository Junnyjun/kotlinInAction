package spring.action.kotlin.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional
import spring.action.kotlin.db.IngredientRepository
import spring.action.kotlin.entity.Ingredient
import spring.action.kotlin.entity.Type.WRAP
import java.util.*
import javax.persistence.EntityManager


@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = NONE)
class IngredientDBTest{
    @Autowired
    lateinit var ingredientRepository : IngredientRepository;

    @BeforeEach
    fun `setUp`(){
        val ingredient = Ingredient(
            "id",
            "Name",
            WRAP)
        val save = ingredientRepository.save(ingredient)
    }
    @Test
    fun `save test`(){
        val ingredient = Ingredient(
            "id",
            "Name",
            WRAP)
        val save = ingredientRepository.save(ingredient)

        assertEquals("id", save.id)
    }
    @Test
    fun `update test`(){
        val save = ingredientRepository.findById(1L)
            .orElseThrow{ RuntimeException("NOT NULL")}
        save.name = "new"
    }
}


