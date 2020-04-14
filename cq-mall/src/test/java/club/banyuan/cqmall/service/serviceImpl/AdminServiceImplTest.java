package club.banyuan.cqmall.service.serviceImpl;

import club.banyuan.cqmall.service.AdminService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    AdminService adminService;

    @Test
    void testLogin() {
    }

    @Test
    void testSelectByUsername() {
    }

    @Test
    void testLoadUserByUsername() {
    }

    @Test
    void testSelectAdminInfo() {
        System.out.println(adminService.selectAdminInfo("admin"));
        Assert.assertNotNull(adminService.selectAdminInfo("admin"));
    }

    @Test
    void selectAdminList() {
        System.out.println(adminService.selectAdminList(0,3,"ad"));
    }
}