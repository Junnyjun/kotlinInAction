package spring.action.kotlin.entity

import javax.persistence.Id

class Ingredient(
    @Id
    val id: String,
    val name: String,
    val type: Type,
) {

    enum class Type { WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE }
}