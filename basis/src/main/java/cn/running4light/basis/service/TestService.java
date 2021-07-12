package cn.running4light.basis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
        ServiceInstance basis2 = client.getInstances("basis2").get(0);
        String host = basis2.getHost();
        String instanceId =  basis2.getInstanceId();
        int port = basis2.getPort();
        String serviceId = basis2.getServiceId();
        String forObject = restTemplate.getForObject("http://"+host+":" + port + "/basis2/findBasis2", String.class);
        return forObject;
    }
}
