package br.com.aewinformatica.patrimonio.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
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

	    configuration.setAllowedMethods(Arrays.asList("*"));
	    configuration.setAllowedHeaders(Arrays.asList("*"));
	    configuration.setExposedHeaders(Arrays.asList("*"));
	    /*When allowCredentials is true, 
	    allowedOrigins cannot contain the special value "*" 
	    since that cannot be set on the "Access-Control-Allow-Origin" 
	    response header. To allow credentials to a set of origins, 
	    list them explicitly or consider using "allowedOriginPatterns" instead.
	    */
	    configuration.setAllowCredentials(false);
	    configuration.setAllowedOrigins(Arrays.asList("*"));
	    configuration.setAllowedOriginPatterns(Arrays.asList("*"));

	  
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
	

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    
    			http
    			.cors(cors -> cors.configurationSource(apiConfigurationSource()))
    			.csrf(AbstractHttpConfigurer::disable)
    			.sessionManagement(manager -> manager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ).authorizeHttpRequests((authz) -> authz
	                .anyRequest().authenticated()
	             ).httpBasic(Customizer.withDefaults())
	             .formLogin(Customizer.withDefaults())
	             .headers(header -> header
    					.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
    					.addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
    			 );
	        
	        return http.build();
	    }
	   

    @Bean
    UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withUsername("aewinformatica")
				.password(passwordEncoder().encode("password"))
				.roles("ADMIN")
				.build();
//		System.out.println(user);

		return new InMemoryUserDetailsManager(user);
	}
    

    @Bean
    PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}