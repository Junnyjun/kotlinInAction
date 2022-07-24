package spring.action.kotlin.web

import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import spring.action.kotlin.db.user.UserRepository
import spring.action.kotlin.entity.Taco
import spring.action.kotlin.entity.TacoRepository


@RestController
@RequestMapping(path = ["/design"], produces = ["application/json"])
@CrossOrigin("*")
class V2DesignTacoController (
    private val userRepo: UserRepository,
    private val tacoRepo: TacoRepository
){
    @GetMapping
    fun recentTacos(): Iterable<Taco>{
        val page = PageRequest.of(0,10);
        return tacoRepo.findAll(page).content
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<Taco>? {
       return tacoRepo.findById(id).get()
           .takeIf { return ResponseEntity(it, HttpStatus.OK) }
           ?.let {ResponseEntity(null, HttpStatus.OK)  }
    }

    @PostMapping
    @ResponseStatus(CREATED)
    fun save(@RequestBody taco: Taco): Taco {
        return tacoRepo.save(taco);
    }
}