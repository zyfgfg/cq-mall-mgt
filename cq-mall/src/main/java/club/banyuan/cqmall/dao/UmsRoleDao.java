package club.banyuan.cqmall.dao;

import club.banyuan.cqmall.dao.entity.UmsRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsRoleDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsRole record);

    int insertSelective(UmsRole record);

    UmsRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsRole record);

    int updateByPrimaryKey(UmsRole record);

    List<UmsRole> selectByUserId(Long userId);

    List<UmsRole> selectByKeyword(@Param("keyword") String keyword);
}