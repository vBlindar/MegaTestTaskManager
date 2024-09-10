package kg.mega.vblindar.mega_test.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{

    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin1").roles("ADMIN");
    }

    protected void configure(HttpSecurity http) throws Exception
    {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers("/task").fullyAuthenticated()
                .antMatchers("/api").permitAll().and()
                .csrf().disable()
                .headers()
                .frameOptions().disable();
    }

}