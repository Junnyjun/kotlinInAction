package spring.action.kotlin.db

import org.springframework.data.repository.CrudRepository
import spring.action.kotlin.entity.Order

interface OrderRepository : CrudRepository<Order, Long>{
}