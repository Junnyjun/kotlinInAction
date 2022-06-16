package spring.action.kotlin.db

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import spring.action.kotlin.entity.Ingredient
import java.sql.ResultSet

@Repository
class JdbcIngredientRepository() {
    private lateinit var jdbc: JdbcTemplate


    private fun mapRowToIngredient(rs : ResultSet, rowNum : Int): Ingredient{
        return Ingredient(
            rs.getString("id"),
            rs.getString("name"),
            Ingredient.Type.valueOf(rs.getString("type"))
        );
    }
}