package spring.action.kotlin.entity

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order,Long> {
}