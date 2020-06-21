package in.marwaadi.service.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author anil.agrawal
 *
 */
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 6427119486745106733L;

	private final Long jwtTokenValidityTimeInSeconds;

	private final String secret;

	public JwtTokenUtil(Long jwtTokenValidityTimeInSeconds, String secret) {
		super();
		this.jwtTokenValidityTimeInSeconds = jwtTokenValidityTimeInSeconds;
		this.secret = secret;
	}

	/**
	 * @author anil.agrawal
	 * @param token
	 * @return
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	/**
	 * @author anil.agrawal
	 * @param userName
	 * @return
	 */
	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userName);
	}

	private String doGenerateToken(Map<String, Object> claims, String userName) {
		long currentTimeMillis = System.currentTimeMillis();
		return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(currentTimeMillis))
				.setExpiration(new Date(currentTimeMillis + (jwtTokenValidityTimeInSeconds * 1000)))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

}
