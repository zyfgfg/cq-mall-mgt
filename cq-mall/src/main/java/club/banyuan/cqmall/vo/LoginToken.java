package club.banyuan.cqmall.vo;

public class LoginToken {
    private String tokenHead;
    private String token;

    public LoginToken() {
    }

    public LoginToken(String tokenHead, String token) {
        this.tokenHead = tokenHead;
        this.token = token;
    }

    public String getTokenHead() {
        return tokenHead;
    }

    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginToken{" +
                "tokenHead='" + tokenHead + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
