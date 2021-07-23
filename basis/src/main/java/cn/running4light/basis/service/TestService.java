package cn.running4light.basis.service;

import cn.running4light.common.ServiceList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/12 14:30
 */
@Service
public class TestService {
    private final Logger log = LoggerFactory.getLogger(TestService.class);
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
        String forObject = restTemplate.getForObject("http://"+ ServiceList.basis2 + "/basis2/basis2test/findBasis2", String.class);
        return forObject;
    }
    /**
     * @Description
     * @Author running4light朱泽雄
     * @CreateTime 10:59 2021/7/23
     * @Return
     */
    public ResponseEntity<String> tokenTransfer2(HttpServletRequest request) {
        // 根据服务名获取目标服务的主机名端口号等信息
        List<ServiceInstance> basis2 = client.getInstances("basis2");

        HttpHeaders headers = new HttpHeaders();
        headers.add("token", request.getHeader("token"));
        ResponseEntity<String> exchange = restTemplate.exchange(
                "http://" + ServiceList.basis2 + "/basis2/basis2Test/testTokenTransfer2",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class
        );
        return exchange;
    }
}
