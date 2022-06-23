//package com.example.proiectawbd.configuration;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@Profile("mysql")
//public class SecurityJdbcConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                    .dataSource(dataSource)
//                    .usersByUsernameQuery("select username,password,enabled "
//                            + "from publisher "
//                            + "where username = ?")
//                    .authoritiesByUsernameQuery("select username, authority "
//                            + "from authorities "
//                            + "where username = ?");
//        }
//
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").hasAnyRole("GUEST","ADMIN")
//                .antMatchers("/librarian/new").hasRole("ADMIN")
//                .antMatchers("/librarian/delete/*").hasRole("ADMIN")
//                .antMatchers("/librarian/update/*").hasRole("ADMIN")
//                .antMatchers("/book/new").hasRole("ADMIN")
//                .antMatchers("/book/delete/*").hasRole("ADMIN")
//                .antMatchers("/book/update/*").hasRole("ADMIN")
//                .antMatchers("/library/new").hasRole("ADMIN")
//                .antMatchers("/library/delete/*").hasRole("ADMIN")
//                .antMatchers("/library/update/*").hasRole("ADMIN")
//                .antMatchers("/publisher/new").hasRole("ADMIN")
//                .antMatchers("/publisher/delete/*").hasRole("ADMIN")
//                .antMatchers("/publisher/update/*").hasRole("ADMIN")
//                .antMatchers("/author/new").hasRole("ADMIN")
//                .antMatchers("/author/delete/*").hasRole("ADMIN")
//                .antMatchers("/author/update/*").hasRole("ADMIN")
//                .and()
//                .formLogin().loginPage("/showLogInForm")
//                .loginProcessingUrl("/authUser")
//                .failureUrl("/login-error").permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/access_denied");
//
//    }
//
//
//}
