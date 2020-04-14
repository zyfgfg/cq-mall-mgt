package club.banyuan.cqmall.security;

import club.banyuan.cqmall.dao.entity.UmsAdmin;
import club.banyuan.cqmall.dao.entity.UmsResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UmsAdminDetails implements UserDetails {

    private UmsAdmin umsAdmin;
    private List<? extends GrantedAuthority> authorities;

    public UmsAdminDetails(UmsAdmin umsAdmin, List<? extends GrantedAuthority> authorities) {
        this.umsAdmin = umsAdmin;
        this.authorities = authorities;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return umsAdmin.getPassword();
    }

    public String getUsername() {
        return umsAdmin.getUsername();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
