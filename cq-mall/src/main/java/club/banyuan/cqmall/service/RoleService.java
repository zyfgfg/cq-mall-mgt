package club.banyuan.cqmall.service;

import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.dao.entity.UmsAdmin;
import club.banyuan.cqmall.vo.AdminInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface RoleService {

    CommonPage selectRoleList(Integer pageNum, Integer pageSize, String keyword);
}
