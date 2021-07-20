package cn.running4light.basis.init;

import com.alibaba.csp.sentinel.datasource.*;
//import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.transport.util.WritableDataSourceRegistry;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

/**
 * @author running4light
 * @description 注册规则数据源
 * @createTime 2021/7/20 15:30
 */
public class FileDataSourceInitFunc implements InitFunc {
    @Override
    public void init() throws Exception {
//        final String remoteAddress = "localhost";
//        final String groupId = "Sentinel:Demo";
//        final String dataId = "com.alibaba.csp.sentinel.demo.flow.rule";

//        String ruleDir = System.getProperty("user.home") + "/sentinel/rules";
//        String ruleDir = System.getProperty("user.dir") + "/sentinel/rules";
//        String ruleDir =ResourceUtils.getURL("classpath:").getPath() + File.pathSeparator + "sentinel"+ File.pathSeparator +"rules";
        String ruleDir = "D:"+ File.separator + "zzx" + File.separator +"sentinelRules";
        String flowRulePath = ruleDir + File.separator+ "flow-rule.json";
        // 流控规则
        ReadableDataSource<String, List<FlowRule>> flowRuleRDS = new FileRefreshableDataSource<>(
                flowRulePath,
                flowRuleListParser
        );
        // 将可读数据源注册至FlowRuleManager
        // 这样当规则文件发生变化时，就会更新规则到内存
        FlowRuleManager.register2Property(flowRuleRDS.getProperty());
        WritableDataSource<List<FlowRule>> flowRuleWDS = new FileWritableDataSource<>(
                flowRulePath,
                this::encodeJson
        );
        // 将可写数据源注册至transport模块的WritableDataSourceRegistry中
        // 这样收到控制台推送的规则时，Sentinel会先更新到内存，然后将规则写入到文件中
        WritableDataSourceRegistry.registerFlowDataSource(flowRuleWDS);




        /*ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {}));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());*/
    }

    private Converter<String, List<FlowRule>> flowRuleListParser = source -> JSON.parseObject(
            source,
            new TypeReference<List<FlowRule>>() {
            }
    );
    private <T> String encodeJson(T t) {
        return JSON.toJSONString(t);
    }

   /* public static void main(String[] args) {
        System.err.println(System.getProperty(""));
    }*/
}
