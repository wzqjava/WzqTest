package com.example.autoopendd.MMKV;

import android.content.Context;
import android.content.SharedPreferences;

import com.tencent.mmkv.MMKV;

/**
 * created by ccl on 2019/2/14
 **/
public class MMKVUtil {
    private static final String TAG = "openDD_MMKVUtil";

    /**
     * MMKV初始化
     *
     * @param context 默认为file/mmkv
     */
    public static void initMMKV(Context context) {
        String rootDir = MMKV.initialize(context);
    }

    /**
     * MMKV初始化
     *
     * @param dir 自定义存储路径
     */
    public static void initMMKV(String dir) {
        String rootDir = MMKV.initialize(dir);
    }

    /**
     * 存储数据
     *
     * @param spType
     * @param key
     * @param value
     */
    public static void set(SPType spType, String key, Object value) {
        set(spType.getKey(), spType.getMode(), key, value);
    }

    /**
     * 存储数据
     *
     * @param mmapID
     * @param mode
     * @param key
     * @param value
     */
    public static void set(String mmapID, int mode, String key, Object value) {
        MMKV kv = MMKV.mmkvWithID(mmapID, mode);
        boolean result = false;
        if (value instanceof Integer) {
            result = kv.encode(key, (Integer) value);
        } else if (value instanceof Long) {
            result = kv.encode(key, (Long) value);
        } else if (value instanceof Float) {
            result = kv.encode(key, (Float) value);
        } else if (value instanceof Double) {
            result = kv.encode(key, (Double) value);
        } else if (value instanceof Boolean) {
            result = kv.encode(key, (Boolean) value);
        } else if (value instanceof String) {
            result = kv.encode(key, (String) value);
        } else if (value instanceof byte[]) {
            result = kv.encode(key, (byte[]) value);
        }
    }

    /**
     * 存储数据
     *
     * @param mmapID
     * @param key
     * @param value
     */
    public static void set(String mmapID, String key, Object value) {
        MMKV kv = MMKV.mmkvWithID(mmapID, Context.MODE_PRIVATE);
        boolean result = false;
        if (value instanceof Integer) {
            result = kv.encode(key, (Integer) value);
        } else if (value instanceof Long) {
            result = kv.encode(key, (Long) value);
        } else if (value instanceof Float) {
            result = kv.encode(key, (Float) value);
        } else if (value instanceof Double) {
            result = kv.encode(key, (Double) value);
        } else if (value instanceof Boolean) {
            result = kv.encode(key, (Boolean) value);
        } else if (value instanceof String) {
            result = kv.encode(key, (String) value);
        } else if (value instanceof byte[]) {
            result = kv.encode(key, (byte[]) value);
        }
    }

    /**
     * 存储数据
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        MMKV kv = MMKV.defaultMMKV();
        boolean result = false;
        if (value instanceof Integer) {
            result = kv.encode(key, (Integer) value);
        } else if (value instanceof Long) {
            result = kv.encode(key, (Long) value);
        } else if (value instanceof Float) {
            result = kv.encode(key, (Float) value);
        } else if (value instanceof Double) {
            result = kv.encode(key, (Double) value);
        } else if (value instanceof Boolean) {
            result = kv.encode(key, (Boolean) value);
        } else if (value instanceof String) {
            result = kv.encode(key, (String) value);
        } else if (value instanceof byte[]) {
            result = kv.encode(key, (byte[]) value);
        }
    }

    /**
     * 获取数据
     *
     * @param spType
     * @param key
     * @param defValue
     * @param <T>
     * @return
     */
    public static <T> T get(SPType spType, String key, T defValue) {
        return (T) get(spType.getKey(), spType.getMode(), key, defValue);
    }

    /**
     * 获取数据
     *
     * @param mmapID
     * @param mode
     * @param key
     * @param defValue
     * @param <T>
     * @return
     */
    public static <T> T get(String mmapID, int mode, String key, T defValue) {
        MMKV kv = MMKV.mmkvWithID(mmapID, mode);
        Object result = null;
        if (defValue instanceof Integer) {
            result = kv.decodeInt(key, (Integer) defValue);
        } else if (defValue instanceof Long) {
            result = kv.decodeLong(key, (Long) defValue);
        } else if (defValue instanceof Float) {
            result = kv.decodeFloat(key, (Float) defValue);
        } else if (defValue instanceof Double) {
            result = kv.decodeDouble(key, (Double) defValue);
        } else if (defValue instanceof Boolean) {
            result = kv.decodeBool(key, (Boolean) defValue);
        } else if (defValue instanceof String) {
            result = kv.decodeString(key, (String) defValue);
        } else if (defValue instanceof byte[]) {
            result = kv.decodeBytes(key);
        }
        return (T) result;
    }

    /**
     * 获取数据
     *
     * @param mmapID
     * @param key
     * @param defValue
     * @param <T>
     * @return
     */
    public static <T> T get(String mmapID, String key, T defValue) {
        MMKV kv = MMKV.mmkvWithID(mmapID, Context.MODE_PRIVATE);
        Object result = null;
        if (defValue instanceof Integer) {
            result = kv.decodeInt(key, (Integer) defValue);
        } else if (defValue instanceof Long) {
            result = kv.decodeLong(key, (Long) defValue);
        } else if (defValue instanceof Float) {
            result = kv.decodeFloat(key, (Float) defValue);
        } else if (defValue instanceof Double) {
            result = kv.decodeDouble(key, (Double) defValue);
        } else if (defValue instanceof Boolean) {
            result = kv.decodeBool(key, (Boolean) defValue);
        } else if (defValue instanceof String) {
            result = kv.decodeString(key, (String) defValue);
        } else if (defValue instanceof byte[]) {
            result = kv.decodeBytes(key);
        }
        return (T) result;
    }

    /**
     * 获取数据
     *
     * @param key
     * @param defValue
     * @param <T>
     * @return
     */
    public static <T> T get(String key, T defValue) {
        MMKV kv = MMKV.defaultMMKV();
        Object result = null;
        if (defValue instanceof Integer) {
            result = kv.decodeInt(key, (Integer) defValue);
        } else if (defValue instanceof Long) {
            result = kv.decodeLong(key, (Long) defValue);
        } else if (defValue instanceof Float) {
            result = kv.decodeFloat(key, (Float) defValue);
        } else if (defValue instanceof Double) {
            result = kv.decodeDouble(key, (Double) defValue);
        } else if (defValue instanceof Boolean) {
            result = kv.decodeBool(key, (Boolean) defValue);
        } else if (defValue instanceof String) {
            result = kv.decodeString(key, (String) defValue);
        } else if (defValue instanceof byte[]) {
            result = kv.decodeBytes(key);
        }
        return (T) result;
    }

    /**
     * 删除指定key的数据
     *
     * @param spType
     * @param key
     */
    public static void remove(SPType spType, String key) {
        MMKV kv = MMKV.mmkvWithID(spType.getKey(), spType.getMode());
        kv.removeValueForKey(key);
    }

    /**
     * 删除指定key的数据
     *
     * @param mmapID
     * @param key
     */
    public static void remove(String mmapID, String key) {
        MMKV kv = MMKV.mmkvWithID(mmapID, Context.MODE_PRIVATE);
        kv.removeValueForKey(key);
    }

    /**
     * 删除指定key的数据
     *
     * @param key
     */
    public static void remove(String key) {
        MMKV kv = MMKV.defaultMMKV();
        kv.removeValueForKey(key);
    }

    /**
     * 删除指定key的数据
     *
     * @param spType
     */
    public static void clearAllDef(SPType spType) {
        MMKV kv = MMKV.mmkvWithID(spType.getKey(), spType.getMode());
        kv.clearAll();
    }

    /**
     * 删除全部的数据
     *
     * @param mmapID
     */
    public static void clearAllDef(String mmapID) {
        MMKV kv = MMKV.mmkvWithID(mmapID, Context.MODE_PRIVATE);
        kv.clearAll();
    }


    /**
     * 删除指定key的数据
     */
    public static void clearAllDef() {
        MMKV kv = MMKV.defaultMMKV();
        kv.clearAll();
    }

    /**
     * 老数据迁移
     *
     * @param context
     */
    public static void importSharedPreferencesData(final Context context) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //遍历枚举类迁移全部老数据至mmkv
//                for (SPType sharedType : SPType.values()) {
//                    try {
//                        SharedPreferences oldSP1 = getSharedPreferences(context, sharedType);
//                        if (oldSP1 != null && oldSP1.getAll() != null && oldSP1.getAll().size() > 0) {//有数据迁移 没数据跳过不影响性能
//                            MMKV kv = MMKV.mmkvWithID(sharedType.getKey());
//                            kv.importFromSharedPreferences(oldSP1);
//                            oldSP1.edit().clear().commit();
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                try {
//                    MMKV mmkv = MMKV.mmkvWithID("sp_data");
//                    SharedPreferences sharedPreference = SharePreferenceUtil.getSharedPreference();
//                    mmkv.importFromSharedPreferences(sharedPreference);
//                    SharePreferenceUtil.clear();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }

    /**
     * 获取mmkv实例
     *
     * @param spType
     * @return
     */
    public static MMKV getSharedPreferences(SPType spType) {
        return MMKV.mmkvWithID(spType.getKey(), spType.getMode());
    }

    /**
     * 获取mmkv editor实例
     *
     * @param spType
     * @return
     */
    public static SharedPreferences.Editor getEditor(SPType spType) {
        return MMKV.mmkvWithID(spType.getKey(), spType.getMode()).edit();
    }

    /**
     * 根据内容取得sp实例
     *
     * @param spType
     * @return
     */
    private static SharedPreferences getSharedPreferences(Context context, SPType spType) {
        return context.getSharedPreferences(spType.getKey(),
                spType.getMode());
    }
}
