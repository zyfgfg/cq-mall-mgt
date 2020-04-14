package club.banyuan.cqmall.controller;

import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.common.CommonResult;
import club.banyuan.cqmall.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Value("${token.schema}")
    private String schema;

    @GetMapping("/list")
    @ResponseBody
    public CommonResult ListGet(@RequestParam("pageNum") Optional<Integer> pageNum,
                                @RequestParam("pageSize") Optional<Integer> pageSize,
                                @RequestParam("keyword") Optional<String> keyword){
        CommonPage roleInfo=roleService.selectRoleList(pageNum.orElse(0),pageSize.orElse(5),keyword.orElse(null));
        return CommonResult.success(roleInfo);
    }

}
