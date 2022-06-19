package spring.action.kotlin.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional
import spring.action.kotlin.db.IngredientRepository
import spring.action.kotlin.entity.Ingredient
import spring.action.kotlin.entity.Type.WRAP
import javax.persistence.EntityManager


@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class IngredientDBTest{
    @Autowired
    lateinit var ingredientRepository : IngredientRepository;
    @Autowired
    lateinit var  entityManager: EntityManager

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
        updateName()
        val result = ingredientRepository.findByIdOrNull(1L)
            ?: throw RuntimeException("NOT NULL")
        assertEquals(result.name, "new")
    }

    @Transactional
    fun updateName() {
        val result = ingredientRepository.findByIdOrNull(1L)
            ?: throw RuntimeException("NOT NULL")
        result.name = "new"
    }
}


