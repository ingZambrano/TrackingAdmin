package mx.com.avior.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SuccessHandler successHandler;
	@Autowired
	FailureHandler failureHandler;
	@Autowired
	CustomAuthenticationProvider authenticationProvider;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/Index.jsp").permitAll()
				.regexMatchers("/js/*").permitAll()
				.regexMatchers("/img/*").permitAll()
				.regexMatchers("/css/*").permitAll()
				.antMatchers("/publico/**").permitAll()
				.antMatchers("/administrador/**").access("hasRole('ROLE_ADMIN')").and().sessionManagement()
				.maximumSessions(1);
		http.csrf().disable();
		http.formLogin().loginProcessingUrl("/j_Intellitracker_security_check")
				.loginPage("/index.jsp").successHandler(successHandler)
				.failureHandler(failureHandler)
				.usernameParameter("user").passwordParameter("password");

		super.configure(http);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		super.configure(web);
	}

}