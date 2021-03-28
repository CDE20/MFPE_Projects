package com.cognizant.authorization.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * This is a Utility class which is used to carry out token related operations
 * like creating tokens, checking for validation, setting time limit of a token
 * etc.
 *
 */

@Slf4j
@Service
public class JwtUtil {

	private String secretkey = "sampletest";

	public String extractUsername(String token) {
		log.info("START");
		log.debug("TOKEN {}:", token);
		String extractClaim = extractClaim(token, Claims::getSubject);
		log.debug("EXTRACT CLAIM {}:", extractClaim);
		log.info("END");
		return extractClaim;
	}

	/**
	 * Extracts the Expiry date from the token using getExpiration from Claims
	 * 
	 * @param token
	 * @return the expiry date of token
	 */

	public Date extractExpiration(String token) {
		log.info("START");
		log.debug("TOKEN {}:", token);
		Date expiryDate = extractClaim(token, Claims::getExpiration);
		log.debug("EXPIRY DATE {}:", expiryDate);
		log.info("END");
		return expiryDate;

	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		log.info("START");
		log.debug("TOKEN {}:", token);
		log.debug("CLAIMS RESOLVER {}:", claimsResolver);
		final Claims claims = extractAllClaims(token);
		log.debug("CLAIMS {}:", claims);
		T apply = claimsResolver.apply(claims);
		log.debug("APPLY {}:", apply);
		log.info("END");
		return apply;
	}

	private Claims extractAllClaims(String token) {
		log.info("START");
		log.debug("TOKEN {}:", token);
		Claims claims = Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
		log.debug("CLAIMS {}:", claims);
		log.info("END");
		return claims;
	}

	private Boolean isTokenExpired(String token) {
		log.info("START");
		log.debug("TOKEN {}:", token);
		boolean isTokenExpired = extractExpiration(token).before(new Date());
		log.debug("CHECK TOKEN EXPIRATION {}:", isTokenExpired);
		log.info("END");
		return isTokenExpired;
	}

	/**
	 * Define claims of the token, like Issuer, Expiration, Subject, and the ID
	 * 
	 * @param userDetails
	 * @return
	 */
	public String generateToken(UserDetails userDetails) {
		log.info("START");
		log.debug("USER DETAILS {}:", userDetails);
		Map<String, Object> claims = new HashMap<>();
		log.debug("CLAIMS {}:", claims);
		String createToken = createToken(claims, userDetails.getUsername());
		log.debug("CREATE TOKEN {}:", createToken);
		log.info("END");
		return createToken;
	}

	/**
	 * Token is generated for 30 mins The signature is used to verify the message
	 * wasn't changed along the way
	 * 
	 * @return Token
	 **/
	private String createToken(Map<String, Object> claims, String subject) {
		log.info("START");
		log.debug("CLAIMS {}:", claims);
		log.debug("SUBJECT {}:", subject);
		String token = Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))// token for 30 mins
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
		log.debug("TOKEN {}:", token);
		log.info("END");
		return token;
	}

	/**
	 * 
	 * 
	 * @param token
	 * @param userDetails
	 * @return whether the token is from valid user and is not expired
	 */

	public Boolean validateToken(String token, UserDetails userDetails) {
		log.info("START");
		log.debug("TOKEN {}:", token);
		log.debug("USER DETAILS {}:", userDetails);
		final String username = extractUsername(token);
		log.debug("USERNAME{}:", username);
		log.info("END");
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	/**
	 * @param token
	 * @return whether token is not valid
	 */

	public Boolean validateToken(String token) {
		log.info("START");
		log.debug("TOKEN {}:", token);
		log.info("START");
		return !isTokenExpired(token);
	}
}