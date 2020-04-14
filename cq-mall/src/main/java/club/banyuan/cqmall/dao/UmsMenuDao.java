package club.banyuan.cqmall.dao;

import club.banyuan.cqmall.dao.entity.UmsMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsMenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMenu record);

    int insertSelective(UmsMenu record);

    UmsMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMenu record);

    int updateByPrimaryKey(UmsMenu record);

    List<UmsMenu> selectAllMenu();

    List<Long> selectMenuIdsByRoleIds(List<Long> roleIds);
}