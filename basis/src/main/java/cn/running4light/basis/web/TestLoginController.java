package cn.running4light.basis.web;

import cn.running4light.basis.auth.CheckLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/22 19:03
 */
@RestController
@RequestMapping("/basis/testLogin")
public class TestLoginController {

    /**
     * @Description 测试@CheckLogin注解
     * @Author running4light朱泽雄
     * @CreateTime 19:05 2021/7/22
     * @Return
     */
    @CheckLogin
    @GetMapping("getMsg")
    public String getMsg(){
        return "登录成功！";
    }
}
