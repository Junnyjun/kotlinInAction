package spring.action.kotlin.entity

import org.springframework.hateoas.RepresentationModel
import java.time.LocalDateTime

class TacoResource(
    val name:String,
    val createAt:LocalDateTime
) : RepresentationModel<TacoResource>() {

}