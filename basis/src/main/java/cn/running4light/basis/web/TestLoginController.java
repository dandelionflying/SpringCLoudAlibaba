package cn.running4light.basis.web;

import cn.running4light.basis.auth.CheckLogin;
import cn.running4light.basis.service.TestService;
import cn.running4light.basis.web.feigns.Basis2Web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @Resource
    private TestService testService;
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
    /**
     * @Description 测试RestTemplate token转发
     * @Author running4light朱泽雄
     * @CreateTime 11:21 2021/7/23
     * @Return
     */
    @CheckLogin
    @GetMapping("testTokenTransfer2")
    public ResponseEntity<String> testTokenTransfer2(HttpServletRequest request){
        return testService.tokenTransfer2(request);
    }
    /**
     * @Description  测试RestTemplate token转发--拦截器方式
     * @Author running4light朱泽雄
     * @CreateTime 12:08 2021/7/23
     * @Return
     */
    @CheckLogin
    @GetMapping("testTokenTransfer3")
    public String testTokenTransfer3(HttpServletRequest request){
        return testService.tokenTransfer3();
    }

}
