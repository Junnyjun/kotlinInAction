package spring.action.kotlin.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Order(
    var deliveryName: String? = null,
    val deliveryStreet: String? = null,
    val deliveryCity: String? = null,
    var deliveryState: String? = null,
    val deliveryZip: String? = null,
    val ccNumber: String? = null,
    val ccExpiration: String? = null,
    val ccCVV: String? = null,
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null
) {
}