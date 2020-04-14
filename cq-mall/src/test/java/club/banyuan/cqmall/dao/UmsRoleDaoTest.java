package club.banyuan.cqmall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UmsRoleDaoTest {

    @Autowired
    UmsRoleDao umsRoleDao;

    @Test
    void selectByUserId() {
        System.out.println(umsRoleDao.selectByUserId(3L));
    }
}