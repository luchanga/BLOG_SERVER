package com.blog.util;



import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    /**
     * 1、选择签名的算法
     * 2、生成签名的密钥
     * 3、构建Token信息
     * 4、利用算法和密钥生成Token
     * @param userId
     * @param expires
     * @param key
     * @return
     */
    public static String getJWTString(String userId, Date expires,
                                      Key key) {
        if (expires == null) {
            throw new NullPointerException("null expires is illegal");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Key signingKey = getKey();
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("username", userId);
        JwtBuilder builder = Jwts.builder().setClaims(claims)
                .setId(userId)
                .setIssuedAt(new Date())
                .setExpiration(expires)
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

    public static boolean isValid(String token) {
        try {
            Key key = getKey();
            Jwts.parser().setSigningKey(key).parseClaimsJws(token.trim());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Key getKey () {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretBytes = DatatypeConverter.parseBase64Binary("JWT-TOKEN");
        Key signingKey = new SecretKeySpec(secretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }
}
