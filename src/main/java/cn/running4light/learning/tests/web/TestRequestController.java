package cn.running4light.learning.tests.web;

import cn.running4light.learning.tests.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/16 9:47
 */
@RestController
@RequestMapping("testReq")
public class TestRequestController {

    // post方式，接收对象时，参数必须是json对象，且必须加上 @RequestBody,且User需定义无参构造函数
    @PostMapping("getMockUser")
    public User getMockUser(@RequestBody User user){
        System.err.println(user.getName());
        return user;
    }
    // get方式，接收对象时，参数必须是params参数，不需加@RequestBody
    @GetMapping("getMockUser2")
    public User getMockUser2(User user){
        System.err.println(user.getName());
        return user;
    }

}
