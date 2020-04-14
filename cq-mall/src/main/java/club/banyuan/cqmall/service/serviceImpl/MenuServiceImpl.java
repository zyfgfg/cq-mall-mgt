package club.banyuan.cqmall.service.serviceImpl;

import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.dao.UmsMenuDao;
import club.banyuan.cqmall.dao.entity.UmsMenu;
import club.banyuan.cqmall.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    UmsMenuDao umsMenuDao;

    @Override
    public List<UmsMenu> selectAllMenu() {
        return umsMenuDao.selectAllMenu();
    }

    @Override
    public CommonPage selectMenuList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(umsMenuDao.selectAllMenu());
        CommonPage commonPage=new CommonPage();
        commonPage.setList(pageInfo.getList());
        commonPage.setTotalPage(pageInfo.getPages());
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        return commonPage;
    }
}
