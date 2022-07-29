package spring.action.kotlin.entity

import org.springframework.data.repository.CrudRepository

interface TacoRepository: CrudRepository<Taco, Long> {
}