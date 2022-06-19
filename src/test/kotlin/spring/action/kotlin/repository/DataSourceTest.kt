package spring.action.kotlin.repository

import com.zaxxer.hikari.HikariDataSource
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DataSourceTest {
    @Autowired
    lateinit var datasource: HikariDataSource

    @Test
    fun `connection`(){
        val url = datasource.jdbcUrl
        val username = datasource.username

        Assertions.assertEquals("jdbc:h2:mem:testdb", url)
        Assertions.assertEquals("sa", username)
    }
}