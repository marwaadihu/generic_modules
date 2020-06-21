package in.marwaadi.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @author anil.agrawal
 *
 */
public final class SecurityUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtil.class);

	private SecurityUtil() {
		super();
	}

	/**
	 * Get logged in user
	 * 
	 * @author anil.agrawal
	 * @return
	 */
	public static User getLoggedInPrincipal() {
		LOGGER.trace("getLoggedInPrincipal");
		Authentication authentication = getLoggedInAuthentication();
		return (User) authentication.getPrincipal();
	}

	/**
	 * Get logged in authentication
	 * 
	 * @author anil.agrawal
	 * @return
	 */
	private static Authentication getLoggedInAuthentication() {
		LOGGER.trace("getLoggedInAuthentication");
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
