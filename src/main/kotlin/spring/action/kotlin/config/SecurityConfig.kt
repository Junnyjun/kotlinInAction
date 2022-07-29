//package spring.action.kotlin.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.security.web.DefaultSecurityFilterChain
//
//
//@Configuration
//@EnableWebSecurity
//class SecurityConfig(){
//    @Bean
//    protected fun filterChain(http : HttpSecurity): DefaultSecurityFilterChain? {
//
//        return http
//            .formLogin().disable()
//            .authorizeRequests()
//            .anyRequest().permitAll()
//            .and()
//            .httpBasic()
//            .and()
//            .csrf()
//            .disable()
//            .build()
//    }
//
//    @Bean
//    fun passwordEncoder(): PasswordEncoder {
//        return createDelegatingPasswordEncoder()
//    }
//}