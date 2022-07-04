package spring.action.kotlin.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry


@Configuration
@EnableWebSecurity
class SecurityConfig(){
    @Bean
    protected fun filterChain(http : HttpSecurity): DefaultSecurityFilterChain? {
        http
            .authorizeRequests()
            .antMatchers("/design","orders").hasRole("USER")
            .antMatchers("/","/**").permitAll()
            .and()
            .httpBasic()
            .and()
            .formLogin()
            .loginPage("/login")
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return createDelegatingPasswordEncoder()
    }

    fun addViewController(registry: ViewControllerRegistry){
        registry.addViewController("/").setViewName("home")
        registry.addViewController("/login")
    }
}