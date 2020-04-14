package club.banyuan.cqmall.controller;

import club.banyuan.cqmall.common.CommonPage;
import club.banyuan.cqmall.common.CommonResult;
import club.banyuan.cqmall.service.MenuService;
import club.banyuan.cqmall.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @Value("${token.schema}")
    private String schema;

    @GetMapping("/list/0")
    @ResponseBody
    public CommonResult ListGet(@RequestParam("pageNum") Optional<Integer> pageNum,
                                @RequestParam("pageSize") Optional<Integer> pageSize){
        CommonPage roleInfo=menuService.selectMenuList(pageNum.orElse(0),pageSize.orElse(5));
        return CommonResult.success(roleInfo);
    }

}
