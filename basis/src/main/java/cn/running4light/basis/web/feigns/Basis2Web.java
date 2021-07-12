package cn.running4light.basis.web.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author running4light
 * @description 统一接口管理：定义某个微服务的所有接口
 * @createTime 2021/7/12 16:45
 */
@FeignClient(value = "basis2")
public interface Basis2Web {
    @GetMapping("/basis2/findBasis2")
    String findBasis2();
}
