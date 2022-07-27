package spring.action.kotlin.entity

import org.jetbrains.annotations.NotNull
import spring.action.kotlin.db.user.User
import javax.persistence.ManyToOne

class Order(
    var deliveryName: String? = null,
    val deliveryStreet: String? = null,
    val deliveryCity: String? = null,
    var deliveryState: String? = null,
    val deliveryZip: String? = null,
    val ccNumber: String? = null,
    val ccExpiration: String? = null,
    val ccCVV: String? = null,
    @ManyToOne
    var user: User? = null
)