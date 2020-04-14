package club.banyuan.cqmall.controller;

import club.banyuan.cqmall.annotation.LoggerAnnotation;
import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.common.CommonResult;
import club.banyuan.cqmall.dao.entity.UmsMenu;
import club.banyuan.cqmall.dto.AdminLoginParam;
import club.banyuan.cqmall.service.AdminService;
import club.banyuan.cqmall.vo.AdminInfo;
import club.banyuan.cqmall.vo.LoginToken;
import org.apache.ibatis.annotations.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Value("${token.schema}")
    private String schema;

    @LoggerAnnotation
    @PostMapping("/login")
    @ResponseBody
    public CommonResult loginPost(@RequestBody AdminLoginParam adminLoginParam){
        String token=adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword());
        LoginToken loginToken=new LoginToken(schema,token);
        return CommonResult.success(loginToken);
    }

    @GetMapping("/info")
    @ResponseBody
    public CommonResult infoGet(Principal principal){
        AdminInfo adminInfo=adminService.selectAdminInfo(principal.getName());
        return CommonResult.success(adminInfo);
    }

    @GetMapping("/list")
    @ResponseBody
    public CommonResult ListGet(@RequestParam("pageNum") Optional<Integer> pageNum,
                                @RequestParam("pageSize") Optional<Integer> pageSize,
                                @RequestParam("keyword") Optional<String> keyword){
        CommonPage adminInfo=adminService.selectAdminList(pageNum.orElse(0),pageSize.orElse(5),keyword.orElse(null));
        return CommonResult.success(adminInfo);
    }

}
