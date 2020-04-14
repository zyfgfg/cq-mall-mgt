package club.banyuan.authentication.service.impl;

import club.banyuan.authentication.service.ResourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResourceServiceImplTest {

    @Autowired
    ResourceService resourceService;

    @Test
    void listAllResource() {
        System.out.println(resourceService.listAllResource());
    }

    @Test
    void listResourceByUserName() {
        System.out.println(resourceService.listResourceByUserName("orderAdmin"));
    }
}