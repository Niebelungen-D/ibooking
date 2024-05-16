//package com.huawei.ibooking.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
////开启判断用户对某个控制层的方法是否具有访问权限的功能
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
////    @Autowired
////    private UserServiceImpl userService;
////    @Autowired
////    private LoginFilter loginFilter;
////
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors(withDefaults()).csrf().disable();
//        http.headers().frameOptions().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        http.addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class);
//        http.authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/*.png").permitAll()
//                .antMatchers("/*.js").permitAll()
//                .antMatchers("/admin/**").authenticated();
//        super.configure(http);
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        // 指定UserDetailService和加密器
////        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
////    }
//
//    @Bean
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
