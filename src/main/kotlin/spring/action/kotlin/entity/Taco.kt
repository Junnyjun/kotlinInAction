package spring.action.kotlin.entity

import org.springframework.data.rest.core.annotation.RestResource
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@RestResource(rel = "taco", path = "tacos")
class Taco(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String? = null,
)