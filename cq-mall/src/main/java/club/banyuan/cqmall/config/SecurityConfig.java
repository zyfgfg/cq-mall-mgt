package club.banyuan.cqmall.config;

import club.banyuan.cqmall.annotation.LoggerAnnotation;
import club.banyuan.cqmall.security.DynamicAuthorizationFilter;
import club.banyuan.cqmall.security.JwtAuthenticationFilter;
import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;
import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/admin/login")
                .antMatchers(HttpMethod.OPTIONS,"/**");

    }

    @LoggerAnnotation
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().anyRequest().authenticated();

        JwtAuthenticationFilter jwtAuthenticationFilter=new JwtAuthenticationFilter();
        autowireCapableBeanFactory.autowireBean(jwtAuthenticationFilter);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        DynamicAuthorizationFilter dynamicAuthorizationFilter=new DynamicAuthorizationFilter();
        autowireCapableBeanFactory.autowireBean(dynamicAuthorizationFilter);
        http.addFilterBefore(dynamicAuthorizationFilter, FilterSecurityInterceptor.class);

    }
}
