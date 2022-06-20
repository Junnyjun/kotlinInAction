package spring.action.kotlin.entity

import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    val userName:String? = null,
    val password:String? = null
)