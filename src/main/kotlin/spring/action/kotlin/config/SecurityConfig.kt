package spring.action.kotlin.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableWebSecurity
open class SecurityConfig(
    private val dataSource: HikariDataSource
){


    @Bean
    protected fun configure(http : HttpSecurity){
        http
            .authorizeRequests()
            .antMatchers("/design","orders").hasRole("ROLE_USER")
            .antMatchers("/","/**").permitAll()
            .and()
            .httpBasic()
    }

    @Bean
    protected fun configure(auth : AuthenticationManagerBuilder){
        auth
            .inMemoryAuthentication()
            .passwordEncoder(passwordEncoder())
            .withUser("user")
            .password(passwordEncoder()?.encode("password") ?: return)
            .roles("USER")
            .and()
            .passwordEncoder(passwordEncoder())
            .withUser("admin")
            .password(passwordEncoder()?.encode("password") ?: return)
            .roles("ADMIN")

        auth
            .jdbcAuthentication()
            .dataSource(dataSource)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return createDelegatingPasswordEncoder()
    }
}