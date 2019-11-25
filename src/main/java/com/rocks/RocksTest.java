package com.rocks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RocksTest {

    public static void main(String[] args) {
        System.out.println("------ 查询有哪些数据库 ------");
        RocksDbUtil.getDBs().forEach(System.out::println);



        System.out.println("------ 初始化数据库 ------");
        //RocksDbUtil.loadAllRocksDB();
        System.out.println("------ 添加数据 ------");
        RocksDbUtil.put("key1", "val1");
        RocksDbUtil.put("key2", "val2");
        RocksDbUtil.put("key3", "val3");

        System.out.println("------ 获取 key1 ------");
        System.out.println("key1 is: "+RocksDbUtil.get("key1"));

        System.out.println("----- 批量获取 key1 key2 key3 ------");
        List<String> keys = Arrays.asList("key1", "key2", "key3");
        List<String> values = RocksDbUtil.multiGet(keys);
        values.forEach(System.out::println);

        System.out.println("------ 打印全部 ------");
        Map<String, String> all = RocksDbUtil.getAll();
        all.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("------ 删除 key1 后，打印全部 ------");
        RocksDbUtil.del("key1");
        all = RocksDbUtil.getAll();
        all.forEach((key, value) -> System.out.println(key + " : " + value));


    }
}
