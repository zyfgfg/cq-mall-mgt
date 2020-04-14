package club.banyuan.authentication.dao;

import club.banyuan.authentication.dao.entity.UmsAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsAdminDao {

  int deleteByPrimaryKey(Long id);

  int insert(UmsAdmin record);

  int insertSelective(UmsAdmin record);

  UmsAdmin selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(UmsAdmin record);

  int updateByPrimaryKey(UmsAdmin record);

  UmsAdmin selectByUsername(String username);
}