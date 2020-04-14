package club.banyuan.authentication.service;

import club.banyuan.authentication.dao.entity.UmsResource;

import java.util.List;

public interface ResourceService {

  List<UmsResource> listAllResource();

  List<UmsResource> listResourceByUserName(String name);
}
