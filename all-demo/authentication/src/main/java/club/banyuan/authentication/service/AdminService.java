package club.banyuan.authentication.service;

import club.banyuan.authentication.dao.entity.UmsAdmin;
import club.banyuan.authentication.security.AdminUserDetails;

public interface AdminService {

  String login(String username, String password);

  UmsAdmin getUserByUsername(String username);

  AdminUserDetails loadUserByUsername(String username);
}
