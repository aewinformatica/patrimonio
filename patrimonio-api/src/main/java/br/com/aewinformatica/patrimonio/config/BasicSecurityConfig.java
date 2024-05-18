package br.com.aewinformatica.patrimonio.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SuppressWarnings("deprecation")
@Profile("basic-security")
@Configuration
@EnableWebSecurity
public class BasicSecurityConfig{
			
	@Bean
	CorsConfigurationSource apiConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	    configuration.setAllowedMethods(Arrays.asList("POST", "GET", "DELETE", "PUT", "OPTIONS"));
	    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));
	    configuration.setAllowCredentials(true);
	    configuration.setMaxAge((long) 3600);
	  
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
	

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    			http.cors(cors -> cors.configurationSource(apiConfigurationSource()))
	            .authorizeHttpRequests((authz) -> authz
	                .anyRequest().authenticated()
	            ).httpBasic(Customizer.withDefaults());
	        
	        return http.build();
	    }
	   

    @Bean
    UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withUsername("aewinformatica")
				.password("password")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
    
    @Bean
    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
    	return NoOpPasswordEncoder.getInstance();
    }

}