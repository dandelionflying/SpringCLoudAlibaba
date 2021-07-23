package cn.running4light.basis2.web;

import cn.running4light.basis2.auth.CheckLogin;
import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/12 14:44
 */
@RestController
@RequestMapping("/basis2/basis2Test")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @CheckLogin
    @GetMapping("findBasis2")
    public String findBasis2(){
        /*try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
//        double ss = 1/0;
        System.err.println("请求成功");
        return "findBasis2Success";
    }
    /**
     * @Description 测试feign的token传递
     * @Author running4light朱泽雄
     * @CreateTime 19:48 2021/7/22
     * @Return
     */
    @RequestMapping("testTokenTransfer")
    @CheckLogin
    public String testTokenTransfer(HttpServletRequest request){

        logger.info("");
        return "basis2放行";
    }
    /**
     * @Description  测试RestTemplate的token传递
     * @Author running4light朱泽雄
     * @CreateTime 11:21 2021/7/23
     * @Return
     */
    @RequestMapping("testTokenTransfer2")
    @CheckLogin
    public String testTokenTransfer2(){

        logger.info("basis2/testTokenTransfer2放行");
        return "basis2/testTokenTransfer2放行";
    }
}
