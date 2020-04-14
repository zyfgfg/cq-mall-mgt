package club.banyuan.cqmall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("club.banyuan.cqmall.dao")
@EnableTransactionManagement
public class MyBatisConfig {
    
}
