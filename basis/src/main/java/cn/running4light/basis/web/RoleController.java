package cn.running4light.basis.web;

import cn.running4light.basis.auth.CheckAuth;
import cn.running4light.basis.auth.CheckLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/23 13:18
 */
@RestController
@RequestMapping("/basis/role")
public class RoleController {

    @GetMapping("testRole")
    @CheckAuth("admin")
    public String testRole(){
        return "权限验证通过";
    }
}
