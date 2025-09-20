package com.yamato.authjava.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.Map;

public class JwtHs256 {
    public static String sign(String subject, String secret, long ttlSeconds, Map<String, Object> extra) {
        if (secret == null || secret.isEmpty()) {
            throw new IllegalArgumentException("missing JWT secret");
        }
        byte[] key = secret.getBytes();
        long nowMs = System.currentTimeMillis();
        Date now = new Date(nowMs);
        Date exp = new Date(nowMs + ttlSeconds * 1000);
        var builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(Keys.hmacShaKeyFor(key), SignatureAlgorithm.HS256);
        if (extra != null) {
            for (var e : extra.entrySet()) {
                builder.claim(e.getKey(), e.getValue());
            }
        }
        return builder.compact();
    }
}
