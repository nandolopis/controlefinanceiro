package br.com.fernando.lopes.finance.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	private static final String[] PUBLIC_MATCHERS = {
			"/h2-console/**",
			"/bancos/**",
			"/caterorias/**",
			"/movimentos/**",
			"/contas/**",
			"/lancamentos/**",
			"/clientes/**"
			
	
	};
	
	private static final String[] PUBLIC_MATCHERS_GET = {
			"/h2-console/**",
			"/bancos/**",
			"/caterorias/**",
			"/movimentos/**",
			"/contas/**",
			"/lancamentos/**",
			"/clientes/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//liberar o h2
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		//desabilita o cors csrf - protocolo conta ataque 
		http.cors().and().csrf().disable();
		
		http.cors().disable();
		
		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll();
		// http.authorizeRequests().antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll();
		
		/*permitir todos os resources que estao no vetor PUBLIC_MATCHERS
		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll()
								.anyRequest().authenticated();*/
		
		//para nao criar sessao do usuario 
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	//permitir acesso por multiplas fontes
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
	/*
	 * Criptografrar as senha
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

