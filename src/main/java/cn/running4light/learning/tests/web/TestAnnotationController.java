package cn.running4light.learning.tests.web;

import cn.running4light.learning.tests.service.AutowiredAndResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/9 15:37
 */
@RestController
@RequestMapping("testAnn")
public class TestAnnotationController {

    @Autowired
    private AutowiredAndResourceService autowiredAndResourceService;
    @GetMapping("test1")
    public String test1(){
        autowiredAndResourceService.func();
        return "";
    }
}
