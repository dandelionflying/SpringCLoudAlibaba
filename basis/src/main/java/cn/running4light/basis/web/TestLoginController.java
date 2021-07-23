package cn.running4light.basis.web;

import cn.running4light.basis.auth.CheckLogin;
import cn.running4light.basis.web.feigns.Basis2Web;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Basis2Web basis2Web;
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
    /**
     * @Description 测试token转发
     * @Author running4light朱泽雄
     * @CreateTime 10:51 2021/7/23
     * @Return
     */
    @CheckLogin
    @GetMapping("testTokenTransfer")
    public String testTokenTransfer(){
        return basis2Web.testTokenTransfer();

    }
}
