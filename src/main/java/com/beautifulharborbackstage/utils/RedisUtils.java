package com.beautifulharborbackstage.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取连接池对象
 */
@Log
public enum RedisUtils {
    INSTANCE;
    static JedisPool jedisPool = null;


    static {
        //1 创建连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //2 进行配置-四个配置
        config.setMaxIdle(1);//最小连接数
        config.setMaxTotal(300);//最大连接数
        config.setMaxWaitMillis(10 * 1000L);//最长等待时间
        config.setTestOnBorrow(true);//测试连接时是否畅通
        //3 通过配置对象创建连接池对象
        try {
            Yaml yaml = new Yaml();
            InputStream resourceAsStream = RedisUtils.class.getClassLoader().getResourceAsStream("application.yml");
            JSONObject redisObj = JSONObject.parseObject(JSONObject.toJSONString(yaml.load(resourceAsStream))).getJSONObject("spring").getJSONObject("redis");
            String host = redisObj.getString("host");
            String port = redisObj.getString("port");
            String password = redisObj.getString("password");
            String timeout = redisObj.getString("timeout");
            log.info("redis [ host:"+host+", port:"+port+", password:"+password+", timeout:"+timeout+" ]");
            jedisPool = new JedisPool(config, host, Integer.valueOf(port),Integer.valueOf(timeout), password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public Jedis getSource() {
        return jedisPool.getResource();
    }

    //关闭资源
    public void closeSource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }

    }
    /**
     * 设置字符值
     *
     * @param key
     * @param
     */
    public void del(String key) {
        Jedis jedis = getSource();
        jedis.del(key);
        closeSource(jedis);
    }
    /**
     * 设置字符值
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis = getSource();
        jedis.set(key, value);
        closeSource(jedis);
    }

    /**
     * 设置
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value) {
        Jedis jedis = getSource();
        jedis.set(key, value);
        closeSource(jedis);
    }

    /**
     *
     * @param key
     * @return
     */
    public byte[]  get(byte[] key) {
        Jedis jedis = getSource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSource(jedis);
        }
        return null;

    }

    /**
     * 设置字符值
     *
     * @param key
     */
    public String get(String key) {
        Jedis jedis = getSource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSource(jedis);
        }

        return null;

    }

    public void set(String key, String value, Integer time) {
        Jedis jedis = getSource();
        jedis.setex(key,time,value);
        closeSource(jedis);
    }
}