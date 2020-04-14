package club.banyuan.cqmall.service;

import java.util.Map;

public interface TokenService {
    String generateToken(String subject);

    String parseToken(String token);

    String generateToken(Map<String, ?> subject);

    Map<String, Object> parseMapToken(String token);

    String refreshTokenDate(String token);

    Boolean isExpired(String token);

    long getExpiredSec(String token);
}
