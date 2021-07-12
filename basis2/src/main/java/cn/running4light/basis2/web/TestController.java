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
        return "findBasis2Success";
    }
}
