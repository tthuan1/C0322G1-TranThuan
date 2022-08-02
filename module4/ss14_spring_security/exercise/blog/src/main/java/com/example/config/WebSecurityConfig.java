package com.example.config;

import com.example.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    cài đặt cách lấy thông tin UserDetail , cơ chế mã hoá pass

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity https) throws Exception {
        https.csrf().disable()
                .formLogin()
                .loginPage("/c0322g1")
                .defaultSuccessUrl("/").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/","/view/**").hasRole("USER")
                .antMatchers("/**").hasRole("ADMIN")
                .anyRequest().authenticated();

        https.authorizeRequests().and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(24*60*60);

    }

   @Bean
    public PersistentTokenRepository persistentTokenRepository(){
       InMemoryTokenRepositoryImpl inMemoryTokenRepository =new InMemoryTokenRepositoryImpl();
       return inMemoryTokenRepository;
   }

}
