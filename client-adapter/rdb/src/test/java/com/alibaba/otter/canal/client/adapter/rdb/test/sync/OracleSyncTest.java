package com.alibaba.otter.canal.client.adapter.rdb.test.sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.otter.canal.client.adapter.rdb.RdbAdapter;
import com.alibaba.otter.canal.client.adapter.support.Dml;

public class OracleSyncTest {

    private RdbAdapter rdbAdapter;

    @Before
    public void init() {
        rdbAdapter = Common.init();
    }

    @Test
    public void test01() {
        Dml dml = new Dml();
        dml.setDestination("example");
        dml.setTs(new Date().getTime());
        dml.setType("INSERT");
        dml.setDatabase("Canteen");
        dml.setTable("user");
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> data = new LinkedHashMap<>();
        dataList.add(data);
        data.put("id", 338L);
        data.put("address", "changsha");
        data.put("name", "Eriched");
        data.put("username", "testEric");
        data.put("password", "123456");
        data.put("tel_phone", "18573194921");
        data.put("crt_user", 1L);
        data.put("upd_user", 1L);
        dml.setData(dataList);

        rdbAdapter.sync(Collections.singletonList(dml));
    }

    @Test
    public void testDDL(){
        Dml dml = new Dml();
        dml.setDestination("example");
        dml.setTs(new Date().getTime());
        dml.setDatabase("Canteen");
        dml.setTable("user");
        dml.setIsDdl(true);
        dml.setSql("ALTER TABLE Canteen."+dml.getTable()+" CHANGE test2col testcol INT");

        rdbAdapter.sync(Collections.singletonList(dml));
    }

    @Test
    public void test02() {
        Dml dml = new Dml();
        dml.setDestination("example");
        dml.setTs(new Date().getTime());
        dml.setType("UPDATE");
        dml.setDatabase("mytest");
        dml.setTable("user");
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> data = new LinkedHashMap<>();
        dataList.add(data);
        data.put("id", 1L);
        data.put("name", "Eric2");
        dml.setData(dataList);
        List<Map<String, Object>> oldList = new ArrayList<>();
        Map<String, Object> old = new LinkedHashMap<>();
        oldList.add(old);
        old.put("name", "Eric");
        dml.setOld(oldList);

        rdbAdapter.sync(Collections.singletonList(dml));
    }

}
