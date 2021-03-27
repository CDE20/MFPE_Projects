package com.cognizant.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 * 
 * This class provides several utility methods in context to jwt
 *          token.
 *
 */
@Service 
public class JwtUtil {
	/**
	 * This field contains a secret key which will be used to create a token
	 */
	private String secretkey = "${jwt.secret}";
	@Autowired
	Environment env;
	/**
	 * This method is used to extract the username from the token
	 * 
	 *  token in the string format
	 * 
	 */
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	/**
	 * This method is used to extract the expiration time of the jwt token
	 * 
	 * @param token
	 * @return
	 */

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	/**
	 * This method is used to extract a particular claim for the token
	 * 
	 
	 */
	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	/**
	 * This method is used to extract claims for the token
	 
	 */
	private Claims extractAllClaims(String token) {
		String token1 = token.trim().replaceAll("\0xfffd", "");
		return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token1).getBody();
	}
	/**
	 * Will tell whether the token is expired or not.
	 * 
	
	 */
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	/**
	 * This method will generate token based on the given parameter userDetails
	 * 
	 
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}
	/**
	 * This method is used to create token based on the claims and subject given as
	 * parameter. It will add a signature to the jwt token based on the algorithm
	 * HS256.
	
	 */
	
	private String createToken(Map<String, Object> claims, String subject) {
		String tokenExp=env.getProperty("set.expire.token");
		int tokenExpNum=Integer.parseInt(tokenExp);
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*tokenExpNum))
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
	}
	/**
	 * This method is used to validate token based on the given token and
	 * userDetails as parameter. First from the token we will extract the username
	 * and then will check in the database whether the token extracted username and
	 * the user residing in database is same or not and also will check whether the
	 * token has been expired or not
	 * 
	
	 */
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);

		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	/**
	 * 
	 * This method is used to vaidate the token based on the give parameter as token
	 * and it will check whethet the token is expired or not by calling a method
	 * isTokenExpired()
	 * 
	
	 */
	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}
}
