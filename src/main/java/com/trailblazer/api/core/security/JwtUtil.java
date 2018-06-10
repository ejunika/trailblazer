package com.trailblazer.api.core.security;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.trailblazer.api.core.entities.User;
import com.trailblazer.api.core.utils.TbMessageContainer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class JwtUtil {
	/**
	 * 
	 */
	private static final SignatureAlgorithm SIGNATUREALGORITHM = SignatureAlgorithm.HS256;

	/**
	 * 
	 */
	private static final String BASE64ENCODEDKEY = TextCodec.BASE64.encode(MacProvider.generateKey().getEncoded());

	/**
	 * 
	 */
	protected static Map<String, User> tbSession = new ConcurrentHashMap<>();

	static {
		User u = new User();
		u.setEntityId(111l);
		u.setEmailId("test.user@test.com");
		u.setRoles("ROLE_USER");
		System.out.println(new JwtUtil().generateToken(u));
	}

	/**
	 * @param token
	 * @return
	 */
	public User parseToken(String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(BASE64ENCODEDKEY).parseClaimsJws(token).getBody();
			User user = new User();
			user.setUsername(body.getSubject());
			user.setEntityId(Long.parseLong((String) body.get("userId")));
			user.setRoles(body.get("roles", String.class));
			return user;
		} catch (JwtException | ClassCastException e) {
			return null;
		}
	}

	/**
	 * @param user
	 * @return
	 */
	public String generateToken(User user) {
		String accessToken = null;
		long ttlMillis = 60 * 60 * 1000l;
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + ttlMillis;
		Date now = new Date(nowMillis);
		Date exp = new Date(expMillis);
		Claims claims = Jwts.claims();
		claims.setSubject(user.getUsername());
		claims.setExpiration(exp);
		claims.setIssuedAt(now);
		claims.setIssuer(TbMessageContainer.ISSUER_INFO_TEXT);
		claims.put("userId", user.getEntityId().toString());
		claims.put("emailId", user.getEmailId());
		claims.put("roles", user.getRoles());
		accessToken = Jwts.builder().setClaims(claims).signWith(SIGNATUREALGORITHM, BASE64ENCODEDKEY).compact();
		if (accessToken != null) {
			tbSession.put(accessToken, user);
		}
		return accessToken;
	}
}
