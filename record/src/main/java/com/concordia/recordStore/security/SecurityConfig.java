//package com.concordia.recordStore.security;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SecurityConfig {
//
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
//
//
////        @Bean
////    public InMemoryUserDetailsManager userDetailsManager(){
////        UserDetails john = User.builder().username("john").password("{noop}test123").roles("employee").build();
////
////        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("employee", "manager").build();
////
////        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("employee",  "manager", "admin").build();
////
////        return new InMemoryUserDetailsManager(john, mary, susan);
////// Repeat this process for Mary and Susan, including specific roles.
////    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(configurer ->
//                        configurer
//                                .requestMatchers("records/list/**").hasRole("ADMIN")
//                                .anyRequest().authenticated())
//                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"))
//                .formLogin(form ->
//                        form
//                                .loginPage("/showMyLoginPage")
//                                .loginProcessingUrl("/authenticateTheUser")
//                                .permitAll()
//
//                )
//                .logout(logout -> logout.permitAll()
//                );
//        return http.build();
//    }
//}
