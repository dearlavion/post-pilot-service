package lavion.dear.configuration;

import lavion.dear.authentication.CustomUserDetailsService;
import lavion.dear.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Disable CSRF for REST
                .authorizeRequests()
                //.antMatchers("/public/**").permitAll() // Allow access to "/public/**" without authentication
                .antMatchers(HttpMethod.POST, "/users/**").hasRole(UserRole.ADMIN.getValue())
                .anyRequest().authenticated() // All other requests require authentication
                .and()
                .httpBasic(); // Enable Basic Authentication
    }

    // Create an in-memory user store for demonstration purposes
    /*
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        // Add users with their username, password, and roles
        userDetailsService.createUser(User.withUsername("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build());

        userDetailsService.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build());

        return userDetailsService;
    }*/

    // Password Encoder bean for bcrypt encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}
