package cn.running4light.learning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/8 19:33
 */
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    public String testRestTemplate(){
        // 二者区别：getForEntity可以拿到http响应体的内容，而getForObject只是拿到响应体数据
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http:host:port/api/{param1}", String.class);
        restTemplate.getForEntity("http:host:port/api/{param1}",String.class, 2);

        String forObject = restTemplate.getForObject("http:host:port/api/{param1}", String.class);
        restTemplate.getForObject("http:host:port/api/{param1}",String.class, 2);
        return null;
    }

}
