package cn.running4light.basis.init;

import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
//import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author running4light
 * @description nacos方式push sentinel规则
 * @createTime 2021/7/21 10:17
 */
public class NacosDataSourceInitFunc implements InitFunc {
    final String remoteAddress = "localhost:8848";
    final String groupId = "SENTINEL_GROUP";
    final String dataId = "basis-nacos-flow";
    @Override
    public void init() throws Exception {
        // remoteAddress 代表 Nacos 服务端的地址
        // groupId 和 dataId 对应 Nacos 中相应配置
//        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId,
//                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {}));
//
//
//        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());

    }
}
