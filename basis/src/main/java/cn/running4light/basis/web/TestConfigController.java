package cn.running4light.basis.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author running4light
 * @description nacos配置中心测试
 * @createTime 2021/7/23 16:09
 */
@RestController
@RequestMapping("/basis/testConfig")
@RefreshScope //动态刷新 监听nacos配置中心的变化
public class TestConfigController {

    @Value("${my.config}")
    private String str;
    /**
     * @Description 测试从nacos配置中心读取配置
     * @Author running4light朱泽雄
     * @CreateTime 16:59 2021/7/23
     * @Return
     */
    @GetMapping("getConfigFromNacos")
    public String getConfigFromNacos(){
        return str;
    }
}
