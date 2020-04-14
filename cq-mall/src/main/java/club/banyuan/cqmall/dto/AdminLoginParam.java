package club.banyuan.cqmall.dto;

import javax.validation.constraints.NotBlank;

public class AdminLoginParam {
    @NotBlank(message = "用户民为空")
    private String username;
    @NotBlank(message = "密码为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminLoginParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
