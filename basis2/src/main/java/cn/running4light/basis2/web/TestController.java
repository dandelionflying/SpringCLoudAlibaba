package cn.running4light.basis2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/12 14:44
 */
@RestController
@RequestMapping("basis2")
public class TestController {

    @GetMapping("findBasis2")
    public String findBasis2(){
        /*try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        double ss = 1/0;
        System.err.println("请求成功");
        return "findBasis2Success";
    }
}
