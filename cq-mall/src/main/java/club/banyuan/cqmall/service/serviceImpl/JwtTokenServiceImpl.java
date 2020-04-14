package club.banyuan.cqmall.service.serviceImpl;

import club.banyuan.cqmall.service.TokenService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenServiceImpl implements TokenService {

    @Value("${token.secretKey}")
    private String secretKey;

    @Value("${token.expireSec}")
    private long expireSec;

    public String generateToken(String subject) {
        if (StrUtil.isBlank(subject)) {
            throw new IllegalArgumentException("subject 为 空");
        }
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expireSec * 1000))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String parseToken(String token) {
        Claims claims = getBody(token);
        return claims.getSubject();
    }

    public String generateToken(Map<String, ?> subject) {
        if (CollectionUtil.isEmpty(subject)) {
            throw new IllegalArgumentException("subject 为 空");
        }
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setClaims(new HashMap<>(subject))
                .setExpiration(new Date(System.currentTimeMillis() + expireSec * 1000))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Map<String, Object> parseMapToken(String token) {
        Claims claims = getBody(token);
        return claims;
    }

    public String refreshTokenDate(String token) {
        if(StrUtil.isBlank(token)){
            throw new IllegalArgumentException("token为空");
        }
        if(isExpired(token)){
            throw new IllegalArgumentException("token已过期");
        }
        return generateToken(parseToken(token));
    }

    public Boolean isExpired(String token) {
        return getExpiredSec(token) <= 0;
    }

    public long getExpiredSec(String token) {
        return (getBody(token).getExpiration().getTime() - System.currentTimeMillis()) / 1000;
    }

    private Claims getBody(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            throw new IllegalArgumentException("token无效");
        }
        return claims;
    }
}
