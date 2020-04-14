package club.banyuan.cqmall.service.serviceImpl;

import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.dao.UmsRoleDao;
import club.banyuan.cqmall.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    UmsRoleDao umsRoleDao;

    @Override
    public CommonPage selectRoleList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(umsRoleDao.selectByKeyword(keyword));
        CommonPage commonPage=new CommonPage();
        commonPage.setList(pageInfo.getList());
        commonPage.setTotalPage(pageInfo.getPages());
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        return commonPage;
    }
}
