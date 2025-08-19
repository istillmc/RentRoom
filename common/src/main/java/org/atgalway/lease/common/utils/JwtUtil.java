package org.atgalway.lease.common.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.atgalway.lease.common.exception.LeaseException;
import org.atgalway.lease.common.result.ResultCodeEnum;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static long tokenExpiration = 60 * 60 * 1000L;
    private static SecretKey tokenSignKey = Keys.hmacShaKeyFor("t26iWpMdt7JJK0i1DacnMJpURdQ7RLm9".getBytes());

    public static String createToken(Long userId, String username) {
        String token = Jwts.builder().
                setSubject("LOGIN_USER").
                setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000*24*365L)).
                claim("userId", userId).
                claim("username", username).
                signWith(tokenSignKey, SignatureAlgorithm.HS256).
                compact();
        return token;
    }

    public static Claims parseToken(String token){

        if (token==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }

        try{
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(tokenSignKey).build();
            return jwtParser.parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException e){
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);
        }catch (JwtException e){
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);
        }
    }

    public static void main(String[] args) {
        String token = JwtUtil.createToken(2L, "user");
        System.out.println("ER: " + token);
    }
}
