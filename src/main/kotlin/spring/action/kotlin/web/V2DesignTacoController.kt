package spring.action.kotlin.web

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import spring.action.kotlin.db.user.UserRepository
import spring.action.kotlin.entity.Order
import spring.action.kotlin.entity.OrderRepository
import spring.action.kotlin.entity.Taco
import spring.action.kotlin.entity.TacoRepository


@RestController
@RequestMapping(path = ["/design"], produces = ["application/json"])
@CrossOrigin("*")
class V2DesignTacoController (
    private val userRepo: UserRepository,
    private val tacoRepo: TacoRepository,
    private val orderRepo: OrderRepository
){
    @GetMapping
    fun recentTacos(): Iterable<Taco>{
        val page = PageRequest.of(0,10);
        return tacoRepo.findAll(page).content
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<Taco?> {
        return tacoRepo.findByIdOrNull(id)
            ?.let { ResponseEntity(it, HttpStatus.OK) }
            ?: ResponseEntity(null, HttpStatus.NOT_FOUND)
    }
    @PutMapping("/{orderId}")
    fun putOrder(@RequestBody order:Order): Order {
        return orderRepo.save(order)
    }
    @DeleteMapping("/{orderId}")
    @ResponseStatus(NO_CONTENT)
    fun deleteOrder(@PathVariable("orderId") id: Long) {
        orderRepo.deleteById(id)
    }


    @PatchMapping(path = ["/{orderId}"], consumes = [APPLICATION_JSON_VALUE])
    fun patchOrder(@PathVariable("orderId") orderId:Long,
    @RequestBody order:Order){
        val entity = orderRepo.findByIdOrNull(orderId)!!

        order.deliveryName?.let {entity.deliveryName= it }
        order.deliveryState?.let {entity.deliveryState= it }
    }

    @PostMapping
    @ResponseStatus(CREATED)
    fun save(@RequestBody taco: Taco): Taco {
        return tacoRepo.save(taco);

    }
}