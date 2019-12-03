package com.ufc.br.config;

import com.ufc.br.security.UserDetailsServiceImplementacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImplementacao userDetailsServiceImplementacao;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImplementacao).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.anyRequest().authenticated()
                .antMatchers("/turma/listarTurmas").permitAll()
                .antMatchers("/admin/home").hasRole("ADMIN")
                .antMatchers("/turma/listarTurmas").hasRole("ALUNO")
                .antMatchers("/instrutor/listar").hasRole("INSTRUTOR")
                .and().csrf().disable().formLogin()
                .loginPage("/login/form").defaultSuccessUrl("/admin/homePage").permitAll()
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/login/form/?logout").logoutSuccessUrl("/login/form")
                .permitAll();
    }
}
