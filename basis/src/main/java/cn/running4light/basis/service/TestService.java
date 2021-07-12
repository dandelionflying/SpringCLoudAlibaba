package cn.running4light.basis.service;

import cn.running4light.common.ServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/12 14:30
 */
@Service
public class TestService {
    @Autowired
    DiscoveryClient client;
    @Resource
    private RestTemplate restTemplate;
    public String serviceGet() {
        // 根据服务名获取目标服务的主机名端口号等信息
        List<ServiceInstance> basis2 = client.getInstances("basis2");
      /*  String url = basis2.stream()
                .map(instance->instance.getUri()+"/basis2/findBasis2")
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("当前没有实例"));*/
//        String forObject = restTemplate.getForObject("http://"+host+":" + port + "/basis2/findBasis2", String.class);
//        String forObject = restTemplate.getForObject(url, String.class);

        // restTemplate注入的时候加上@LoadBanlanced注解，就可以直接用服务名称进行服务间通信，不需要再去获取hostport等信息
        String forObject = restTemplate.getForObject("http://"+ ServiceList.basis2 + "/basis2/findBasis2", String.class);
        return forObject;
    }
}
