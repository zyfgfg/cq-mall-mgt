package club.banyuan.cqmall.service.serviceImpl;

import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.dao.UmsResourceDao;
import club.banyuan.cqmall.dao.entity.UmsResource;
import club.banyuan.cqmall.service.ResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    UmsResourceDao umsResourceDao;

    @Override
    public List<UmsResource> selectAllResource() {
        return umsResourceDao.selectAllResource();
    }

    @Override
    public List<UmsResource> selectResourceByUsername(String username) {
        return umsResourceDao.selectResourceByUsername(username);
    }

    @Override
    public CommonPage selectResourceList(Integer pageNum, Integer pageSize, String nameKeyword, String urlKeyword, Integer categoryId) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(umsResourceDao.selectByKeyword(nameKeyword,urlKeyword,categoryId));
        CommonPage commonPage=new CommonPage();
        commonPage.setList(pageInfo.getList());
        commonPage.setTotalPage(pageInfo.getPages());
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        return commonPage;
    }
}
