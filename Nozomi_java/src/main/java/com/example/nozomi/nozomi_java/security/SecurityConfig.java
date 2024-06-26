package com.example.nozomi.nozomi_java.security;

import com.example.nozomi.nozomi_java.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  //细粒度控制
public class SecurityConfig {

    //授权（过滤器
    @Resource
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    AccessDeniedHandlerImpl accessDeniedHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/**").permitAll()  //全域开放(测试开启)

//                .antMatchers("/test/**").permitAll()
//                .antMatchers("/login/**").permitAll()
//                .antMatchers("/admin/**").hasRole("admin")
//                .antMatchers("/boss/**").access("hasAnyRole('boss','admin')")
//                .antMatchers("/employe/**").access("hasAnyRole('boss','employe','admin')")
//                .anyRequest().authenticated()
//                .and()F
//                .formLogin()  //开启表单验证
//                .permitAll();
        //异常处理器
        http.exceptionHandling().
                accessDeniedHandler(accessDeniedHandler);  //权限不足
        //TOKEN Filter
        http.addFilterBefore(jwtAuthenticationTokenFilter,UsernamePasswordAuthenticationFilter.class);
        //关闭CSRF
        http.csrf().disable();
        //允许跨域
        http.cors(Customizer.withDefaults());

        return http.build();
    }

    /**
     * BCrypt加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationConfiguration configuration;
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        AuthenticationManager auth = configuration.getAuthenticationManager();
        return auth;
    }
}































