package com.rocks;

import org.apache.commons.collections4.CollectionUtils;
import org.rocksdb.*;

import java.util.*;
import java.util.stream.Collectors;

public class RocksDbUtil {
    private static final String DB_PATH = "/usr/local/person/rocksdb2/";
    private static RocksDB rocksDB;
    private static List<ColumnFamilyDescriptor> descriptors = new ArrayList<>();
    private static List<ColumnFamilyHandle> handles = new ArrayList<>();
    private static Map<String, ColumnFamilyHandle> handleMap = new HashMap<>();

    static {
        loadRocksDB();
    }

    public static List<String> getDBs() {
        return getDBs(DB_PATH);
    }

    public static List<String> getDBs(String dbPath) {
        try {
            List<byte[]> columnFamilies = RocksDB.listColumnFamilies(new Options(), dbPath);
            return columnFamilies.stream().map(String::new).collect(Collectors.toList());
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void loadRocksDB() {
        loadRocksDB(DB_PATH);
    }

    public static void loadRocksDB(String dbPath) {
        descriptors = getDBs(dbPath).stream()
                .map(db -> new ColumnFamilyDescriptor(db.getBytes(), new ColumnFamilyOptions()))
                .collect(Collectors.toList());
        DBOptions dbOptions = new DBOptions();
        dbOptions.setCreateIfMissing(true);
        loadRocksDB(dbOptions, dbPath, descriptors, handles);
        for (int i = 0; i < descriptors.size(); i++) {
            handleMap.put(new String(descriptors.get(i).columnFamilyName()), handles.get(i));
        }
    }

    public static void loadRocksDB(final DBOptions options, final String path,
                                   final List<ColumnFamilyDescriptor> columnFamilyDescriptors,
                                   final List<ColumnFamilyHandle> columnFamilyHandles) {
        try {
            rocksDB = RocksDB.open(options, path, columnFamilyDescriptors, columnFamilyHandles);
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String tableName) {
        if (tableName == null) {
            return;
        }
        if (handleMap.get(tableName) != null) {
            return;
        }
        try {
            ColumnFamilyHandle columnFamilyHandleNew =
                    rocksDB.createColumnFamily(new ColumnFamilyDescriptor(tableName.getBytes(), new ColumnFamilyOptions()));
            handleMap.put(tableName, columnFamilyHandleNew);
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
    }


    public static void put(String key, String value) {
        if (key == null || value == null) {
            return;
        }
        try {
            rocksDB.put(key.getBytes(), value.getBytes());
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
    }

    public static void put(String tableName, String key, String value) {
        if (tableName == null || key == null || value == null) {
            return;
        }
        try {
            rocksDB.put(handleMap.get(tableName), key.getBytes(), value.getBytes());
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        if (key == null) {
            return null;
        }
        try {
            byte[] bytes = rocksDB.get(key.getBytes());
            return new String(bytes);
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String get(String tableName, String key) {
        if (key == null || tableName == null) {
            return null;
        }
        try {
            byte[] bytes = rocksDB.get(handleMap.get(tableName), key.getBytes());
            return new String(bytes);
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> multiGet(List<String> keys) {
        if (CollectionUtils.isNotEmpty(keys)) {
            List<byte[]> keysByte = keys.stream().map(String::getBytes).collect(Collectors.toList());
            try {
                Map<byte[], byte[]> map = rocksDB.multiGet(keysByte);
                return keysByte.stream().map(key -> new String(map.get(key))).collect(Collectors.toList());
            } catch (RocksDBException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> multiGetMap(List<String> keys) {
        if (CollectionUtils.isNotEmpty(keys)) {
            List<byte[]> keysByte = new ArrayList<>();
            keys.forEach(key -> keysByte.add(key.getBytes()));
            try {
                Map<byte[], byte[]> map = rocksDB.multiGet(keysByte);
                return map.entrySet().stream().collect(
                        Collectors.toMap(entry -> new String(entry.getKey()), entry -> new String(entry.getValue())));
            } catch (RocksDBException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<String> getAllKeys() {
        RocksIterator iterator = rocksDB.newIterator();
        List<String> keys = new ArrayList<>();
        for (iterator.seekToFirst(); iterator.isValid(); iterator.next()) {
            keys.add(new String(iterator.key()));
        }
        return keys;
    }

    public static Map<String, String> getAll() {
        RocksIterator iterator = rocksDB.newIterator();
        Map<String, String> results = new HashMap<>();
        for (iterator.seekToFirst(); iterator.isValid(); iterator.next()) {
            results.put(new String(iterator.key()), new String(iterator.value()));
        }
        return results;
    }

    public static void del(String key) {
        if (key == null) {
            return;
        }
        try {
            rocksDB.delete(key.getBytes());
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
    }

}
