package club.banyuan.authentication.service.impl;

import club.banyuan.authentication.dao.UmsAdminDao;
import club.banyuan.authentication.dao.UmsResourceDao;
import club.banyuan.authentication.dao.entity.UmsResource;
import club.banyuan.authentication.service.ResourceService;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    UmsResourceDao umsResourceDao;

    @Override
    public List<UmsResource> listAllResource() {
        return umsResourceDao.selectAllResource();
    }

    @Override
    public List<UmsResource> listResourceByUserName(String name) {
        return umsResourceDao.selectResourceByUsername(name);
    }
}
