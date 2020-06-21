package in.marwaadi.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author anil.agrawal
 *
 */
@Component
public class SecurityAuthenticationProvider extends DaoAuthenticationProvider {

	public SecurityAuthenticationProvider(UserDetailsService userDetailsService) {
		super();
		super.setUserDetailsService(userDetailsService);
		super.setHideUserNotFoundExceptions(Boolean.FALSE);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		super.setPasswordEncoder(bCryptPasswordEncoder);
		return bCryptPasswordEncoder;
	}

}
