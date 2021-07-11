package cn.running4light.learning.tests.service;

import cn.running4light.learning.tests.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author running4light
 * @description 测试@Resource@Autowired的区别
 * @createTime 2021/7/9 15:22
 */
@Service
public class AutowiredAndResourceService {
    @Autowired
    @Qualifier("user1")
    private User user;
    @Resource
    private User user1;
    @Resource
    private User user2;
//    @Resource
//    private User user3;

    public void func(){
        System.err.println(user1.getName());// 输出user1
        System.err.println(user2.getName());// 输出user2
        System.err.println(user.getName());// 输出user1
//        System.err.println(user3.getName());// 运行时报错
    }
}
