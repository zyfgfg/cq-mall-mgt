package club.banyuan.cqmall.service;

import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.dao.entity.UmsAdmin;
import club.banyuan.cqmall.vo.AdminInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface AdminService {

    String login(String username, String password);

    UmsAdmin selectByUsername(String username);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    AdminInfo selectAdminInfo(String username);

    CommonPage selectAdminList(Integer pageNum, Integer pageSize, String keyword);
}
