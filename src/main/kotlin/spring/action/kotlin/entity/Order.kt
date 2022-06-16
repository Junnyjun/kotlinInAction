package spring.action.kotlin.entity

import org.jetbrains.annotations.NotNull

class Order (){
    @field:NotNull("필수 입력값")
    val deliveryName: String? = null
    @field:NotNull("필수 입력값")
    val deliveryStreet: String? = null
    @field:NotNull("필수 입력값")
    val deliveryCity: String? = null
    @field:NotNull("필수 입력값")
    val deliveryState: String? = null
    @field:NotNull("필수 입력값")
    val deliveryZip: String? = null
    val ccNumber: String? = null
    @field:NotNull("필수 입력값")
    val ccExpiration: String? = null
    val ccCVV: String? = null
}