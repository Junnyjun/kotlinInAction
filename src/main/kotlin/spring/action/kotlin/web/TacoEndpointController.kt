package spring.action.kotlin.web

import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.web.bind.annotation.GetMapping
import spring.action.kotlin.entity.Taco
import spring.action.kotlin.entity.TacoRepository
import java.util.*


@RepositoryRestController
class TacoEndpointController(
    private val tacoRepo: TacoRepository
) {

    @GetMapping(path = ["/taco"], produces = ["application/hal+json"])
    fun tacos(): Optional<Taco> {
        return tacoRepo.findById(1L)
    }
}