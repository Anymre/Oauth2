package resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/** @Author: Marcus @Date: 2019/6/27 14:35 @Version 1.0 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.exceptionHandling()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/")
        .hasRole("admin")
        .antMatchers("/view/**")
        .hasRole("admin")
        .antMatchers("/insert/**")
        .hasAuthority("SystemContentInsert")
        .antMatchers("/update/**")
        .hasAuthority("SystemContentUpdate")
        .antMatchers("/delete/**")
        .hasAuthority("SystemContentDelete");
    ;
  }
}
