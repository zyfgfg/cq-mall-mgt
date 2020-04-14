package club.banyuan.cqmall.service;

import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.dao.entity.UmsAdmin;
import club.banyuan.cqmall.dao.entity.UmsMenu;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface MenuService {

    List<UmsMenu> selectAllMenu();

    CommonPage selectMenuList(Integer pageNum, Integer pageSize);
}