package spring.action.kotlin.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.CrudRepository

interface TacoRepository: CrudRepository<Taco, Long> {
    fun findAll(page: PageRequest): Page<Taco>
}