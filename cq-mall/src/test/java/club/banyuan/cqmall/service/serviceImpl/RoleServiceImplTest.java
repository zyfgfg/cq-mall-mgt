package club.banyuan.cqmall.service.serviceImpl;

import club.banyuan.cqmall.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceImplTest {

    @Autowired
    RoleService roleService;

    @Test
    void selectRoleList() {
        roleService.selectRoleList(0,2,null);
    }
}