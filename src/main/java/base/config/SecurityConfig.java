package base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // ログイン不要画面の設定
        http
                .authorizeRequests()
                .antMatchers("/t001").permitAll()
                .antMatchers("/h2-console/**").permitAll() // H2DBデバッグ用
                .anyRequest().authenticated();

        http.csrf().disable();	// H2DBデバッグ用
        http.headers().frameOptions().disable(); // H2DBデバッグ用

        return http.build();
    }
}