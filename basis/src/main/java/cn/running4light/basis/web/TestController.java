package cn.running4light.basis.web;

import cn.running4light.basis.service.TestService;
import cn.running4light.basis.web.feigns.Basis2Web;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/12 14:29
 */
@RestController
@RequestMapping("/basis/basisTest")
public class TestController {
    private final Logger log = LoggerFactory.getLogger(TestController.class);
    @Resource
    private TestService testService;

    @Autowired
    private Basis2Web basis2Web;

    @GetMapping("serviceGet")
    public String serviceGet(){
        return testService.serviceGet();
    }
    // 使用feign方式进行服务间通信
    @GetMapping("feignTestGet")
    public String feignTestGet(){
        return basis2Web.findBasis2();
    }
    /**
     * @Description 热点参数限流
     * @Author running4light朱泽雄
     * @CreateTime 15:32 2021/7/19
     * @Return
     */
    @GetMapping("hotTest")
    @SentinelResource("hotTest")
    public String hotTest(@RequestParam(required = false) String a, @RequestParam(required = false) String b){
        return a + " " + b;
    }
    /**
     * @Description 测试sentinelAPI
     * @Author running4light朱泽雄
     * @CreateTime 10:21 2021/7/20
     * @Return
     */
    @GetMapping("testSentinelAPI")
    @SentinelResource(
            value = "testSentinelAPI",
            blockHandler = "block",
//            blockHandlerClass =
//            fallbackClass =
            fallback = "fallback"
    )
    public String testSentinelAPI(@RequestParam(required = false) String a){
        if(StringUtils.isBlank(a))
            throw new IllegalArgumentException("a is null");
        return a;
    }
    /**
     * @Description 处理限流或降级
     * @Author running4light朱泽雄
     * @CreateTime 10:24 2021/7/20
     * @Return
     */
    public String block(String a, BlockException e){
        log.warn("blocking...", e);
        return "blocking...";
    }
    /**
     * @Description 处理降级
     * @Author running4light朱泽雄
     * @CreateTime 10:24 2021/7/20
     * @Return
     */
    public String fallback(String a){
        log.warn("fallback...");
        return "fallback...";
    }
    @GetMapping("getPath")
    public String getPath() {
        System.out.println(ZonedDateTime.now());
        String path = null;
        try {
//            path = ResourceUtils.getURL("classpath:").getPath();
            path = System.getProperty("user.dir");// 根路径（非模块根路径）
            System.err.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}
