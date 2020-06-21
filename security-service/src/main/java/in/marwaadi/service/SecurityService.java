package in.marwaadi.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import in.marwaadi.service.config.JwtTokenUtil;

/**
 * @author anil.agrawal
 *
 */
public class SecurityService {

	private final AuthenticationManager authenticationManager;

	private final JwtTokenUtil jwtTokenUtil;

	public SecurityService(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	/**
	 * 1... Perform all the mentioned steps from
	 * {@link https://github.com/marwaadihu/generic_modules/tree/master/security-service#security---service}
	 * Page.
	 * 
	 * 2....Use this method as sample code to get token from this service
	 * 
	 * @author anil.agrawal
	 * @param username
	 * @param password
	 * @return
	 */
	public String getTokenForUser(String username, String password) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return jwtTokenUtil.generateToken(username);
	}

}
