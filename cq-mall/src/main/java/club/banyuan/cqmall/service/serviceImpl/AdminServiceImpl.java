package club.banyuan.cqmall.service.serviceImpl;

import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.common.ReqFailException;
import club.banyuan.cqmall.dao.UmsAdminDao;
import club.banyuan.cqmall.dao.UmsMenuDao;
import club.banyuan.cqmall.dao.UmsResourceDao;
import club.banyuan.cqmall.dao.UmsRoleDao;
import club.banyuan.cqmall.dao.entity.UmsAdmin;
import club.banyuan.cqmall.dao.entity.UmsMenu;
import club.banyuan.cqmall.dao.entity.UmsResource;
import club.banyuan.cqmall.dao.entity.UmsRole;
import club.banyuan.cqmall.security.ResourceConfigAttribute;
import club.banyuan.cqmall.security.UmsAdminDetails;
import club.banyuan.cqmall.service.AdminService;
import club.banyuan.cqmall.service.TokenService;
import club.banyuan.cqmall.vo.AdminInfo;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService, UserDetailsService {
    @Autowired
    UmsAdminDao umsAdminDao;

    @Autowired
    UmsResourceDao umsResourceDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenService tokenService;

    @Autowired
    UmsMenuDao umsMenuDao;

    @Autowired
    UmsRoleDao umsRoleDao;

    @Override
    public String login(String username, String password) {
        UmsAdmin umsAdmin = umsAdminDao.selectByUsername(username);
        if (passwordEncoder.matches(password,umsAdmin.getPassword())) {
            return tokenService.generateToken(username);
        }
        throw new ReqFailException("登录异常");
    }

    public UmsAdmin selectByUsername(String username) {
        return umsAdminDao.selectByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsAdmin umsAdmin = umsAdminDao.selectByUsername(username);
        List<UmsResource> umsResources = umsResourceDao.selectResourceByUsername(username);
        if (umsAdmin == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        List<ResourceConfigAttribute> attributes = umsResources.stream()
                .map(ResourceConfigAttribute::new)
                .collect(Collectors.toList());
        return new UmsAdminDetails(umsAdmin, attributes);
    }

    @Override
    public AdminInfo selectAdminInfo(String username) {
        UmsAdmin user=umsAdminDao.selectByUsername(username);
        List<UmsMenu> umsMenus=umsMenuDao.selectAllMenu();
        List<UmsRole> umsRoles = umsRoleDao.selectByUserId(user.getId());
        List<Long> menuIds = umsMenuDao.selectMenuIdsByRoleIds(umsRoles.stream().map(UmsRole::getId).collect(Collectors.toList()));
        List<UmsMenu> collect = umsMenus.stream().filter(t -> {
            return menuIds.contains(t.getId());
        }).collect(Collectors.toList());
        AdminInfo adminInfo=new AdminInfo();
        adminInfo.setIcon(user.getIcon());
        adminInfo.setUsername(username);
        adminInfo.setMenus(collect);
        adminInfo.setRoles(umsRoles.stream().map(UmsRole::getName).collect(Collectors.toList()));
        return adminInfo;
    }

    @Override
    public CommonPage selectAdminList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo= new PageInfo(umsAdminDao.selectByKeyword(keyword));
        CommonPage commonPage=new CommonPage();
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setTotalPage(pageInfo.getPages());
        commonPage.setList(pageInfo.getList());
        return commonPage;
    }
}
