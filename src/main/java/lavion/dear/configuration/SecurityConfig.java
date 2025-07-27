package lavion.dear.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() // Allow access to "/public/**" without authentication
                .anyRequest().authenticated() // All other requests require authentication
                .and()
                .httpBasic(); // Enable Basic Authentication
    }

    // Create an in-memory user store for demonstration purposes
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
    }

    // Password Encoder bean for bcrypt encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
