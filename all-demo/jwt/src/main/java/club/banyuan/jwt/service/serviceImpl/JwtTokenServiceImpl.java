package club.banyuan.jwt.service.serviceImpl;

import club.banyuan.jwt.service.TokenService;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JwtTokenServiceImpl implements TokenService {

    @Value("${token.secretKey}")
    private String secretKey;

    @Value("${token.expireSec}")
    private long expireSec;

    public String generateToken(String subject) {
        if (StrUtil.isBlank(subject)) {
            throw new IllegalArgumentException("subject为空");
        }
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expireSec * 1000))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String parseToken(String token){
        Claims claims=getBody(token);
        return claims.getSubject();
    }

    public Claims getBody(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {

            return e.getClaims();
        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            throw new IllegalArgumentException("无效的token",e);
        }
        return claims;
    }

}
