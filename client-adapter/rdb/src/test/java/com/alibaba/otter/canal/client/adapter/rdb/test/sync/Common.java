package com.alibaba.otter.canal.client.adapter.rdb.test.sync;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.otter.canal.client.adapter.rdb.RdbAdapter;
import com.alibaba.otter.canal.client.adapter.rdb.test.TestConstant;
import com.alibaba.otter.canal.client.adapter.support.DatasourceConfig;
import com.alibaba.otter.canal.client.adapter.support.OuterAdapterConfig;

public class Common {

    public static RdbAdapter init() {
        DatasourceConfig.DATA_SOURCES.put("defaultDS", TestConstant.dataSource);

        OuterAdapterConfig outerAdapterConfig = new OuterAdapterConfig();
        outerAdapterConfig.setName("rdb");
        outerAdapterConfig.setKey("mysql1");
        Map<String, String> properties = new HashMap<>();
        properties.put("jdbc.driveClassName", "com.mysql.jdbc.Driver");
        properties.put("jdbc.url", "jdbc:mysql://127.0.0.1:31006/statistic?serverTimezone=GMT%2b8&useUnicode=true&characterEncoding=UTF8");
        properties.put("jdbc.username", "root");
        properties.put("jdbc.password", "canteendb2019");
        outerAdapterConfig.setProperties(properties);

        RdbAdapter adapter = new RdbAdapter();
        adapter.init(outerAdapterConfig, null);
        return adapter;
    }
}
