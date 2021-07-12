package cn.running4light.basis.web;

import cn.running4light.basis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/12 14:29
 */
@RestController
@RequestMapping("basisTest")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("serviceGet")
    public String serviceGet(){
        return testService.serviceGet();
    }
}
