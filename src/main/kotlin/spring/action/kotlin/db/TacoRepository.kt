package spring.action.kotlin.db

import org.springframework.data.repository.CrudRepository
import spring.action.kotlin.entity.Taco

interface TacoRepository : CrudRepository<Taco, Long>{
}