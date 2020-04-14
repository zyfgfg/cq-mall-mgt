package club.banyuan.cqmall.dao;

import club.banyuan.cqmall.dao.entity.UmsResource;
import club.banyuan.cqmall.dao.entity.UmsRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsResourceDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsResource record);

    int insertSelective(UmsResource record);

    UmsResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsResource record);

    int updateByPrimaryKey(UmsResource record);

    List<UmsResource> selectAllResource();

    List<UmsResource> selectResourceByUsername(String username);

    List<UmsRole> selectByKeyword(@Param("nameKeyword") String nameKeyword, @Param("urlKeyword") String urlKeyword, @Param("categoryId") Integer categoryId);
}