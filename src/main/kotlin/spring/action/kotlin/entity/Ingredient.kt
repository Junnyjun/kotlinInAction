package spring.action.kotlin.entity

import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id

@Entity
class Ingredient(
    val id: String? = null,
    var name: String? = null,
    @Enumerated(STRING)
    val type: Type? = null,

    @Id
    @GeneratedValue(strategy = AUTO)
    var idx: Long? = null
)
enum class Type { WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE }

