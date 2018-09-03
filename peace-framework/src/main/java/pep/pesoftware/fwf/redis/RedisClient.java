package pep.pesoftware.fwf.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.util.Map;
import java.util.Set;

public class RedisClient {
    private final JedisPool jedisPool;

    public RedisClient(Environment environment){
        String ip = environment.getProperty("peace.redis.host.ip");
        int port = environment.getProperty("peace.redis.host.port",Integer.class);
        String password = environment.getProperty("peace.redis.host.password");
        int maxActive = environment.getProperty("peace.redis.pool.maxActive",Integer.class);
        int maxIdle = environment.getProperty("peace.redis.pool.maxIdle",Integer.class);
        boolean testOnBorrow = environment.getProperty("peace.redis.pool.testOnBorrow",Boolean.class);
        boolean testOnReturn = environment.getProperty("peace.redis.pool.testOnReturn",Boolean.class);
        JedisPoolConfig config = new JedisPoolConfig();
        // 为pool分配jedis实例个数
        config.setMaxTotal(maxActive);
        // 控制一个pool最多有几个状态为空闲的jedis实例
        config.setMaxIdle(maxIdle);
        // borrow一个jedis实例时是否提前进行validate操作，如果为ture则得到的实例都是可用的
        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        if (password != null && password.trim().length() != 0) {
            jedisPool = new JedisPool(config, ip, port, 10000, password);
        } else {
            // 获取连接池10000毫秒延时
            jedisPool = new JedisPool(config, ip, port, 10000);
        }
    }

    private Jedis getJedis() {
        return jedisPool.getResource();
    }

    private void close(Jedis jedis) {
        if(jedis != null){
            jedis.close();
        }
    }

    /**
     * 缓存键值对
     * @param key String
     *          健
     * @param value String
     *          值
     */
    public void set(String key ,String value){
        Jedis jedis = getJedis();
        jedis.set(key,value);
        close(jedis);
    }

    /**
     * 缓存Map<String,String>键值对
     * @param key String
     *          健
     * @param map Map<String,String>
     *          值
     */
    public void setMap(String key ,Map<String,String> map){
        Jedis jedis = getJedis();
//        jedis.del(key);
        if(!map.isEmpty()){
//            System.out.println(key);
//            System.out.println(map.size());
            jedis.hmset(key,map);
        }

        close(jedis);
    }

    public void delKeys(String pattern ){
        Jedis jedis = getJedis();
        Set<String> keys = jedis.keys(pattern );
        if(keys.size()>0){
            String[] delKeys=keys.toArray(new String[0]);
            Long del = jedis.del(delKeys);
//            System.out.println("del******"+pattern);
//            System.out.println(del);
        }

    }

    /**
     * 缓存键值对
     * @param key String
     *          健
     * @param value String
     *          值
     */
    public void setMap(String key ,String field,String value){
        Jedis jedis = getJedis();
        jedis.set(key,value);
        close(jedis);
    }

    /**
     * 通过健获取值
     * @param key String
     *          健
     * @return
     *          值
     */
    public String get(String key){
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        close(jedis);
        return value;
    }

    /**
     * 设置过期时间
     * @param key
     *          健
     * @param seconds
     *          过期时间（秒）
     */
    public void expire(String key,int seconds){
        if (seconds <= 0) {
            return;
        }
        Jedis jedis = getJedis();
        jedis.expire(key,seconds);
        close(jedis);
    }


    /**
     * 删除指定的缓存
     * @param keys
     *          健
     */
    public void del(String... keys){
        if(keys == null){
            return;
        }
        Jedis jedis = getJedis();
        jedis.del(keys);
        close(jedis);
    }

    /**
     * 往Redis中设定HashMap的自加
     * @param key
     *          KEY名
     * @param field
     *          字段名
     * @param count
     *          需要增加的值
     * @return
     *          增加后的值
     */
    public Long hincrBy(String key, String field,int count){
        if(StringUtils.isBlank(key)
                || StringUtils.isBlank(field)
                || count == 0){
            return null;
        }
        Long tempLong = 0L;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            tempLong = jedis.hincrBy(key, field, count);
        }finally {
            close(jedis);
        }
        return tempLong;
    }

    /**
     * 通过Key获取Redis中的数据
     * @param key
     *      Key名
     * @return
     *      返回存储数据
     */
    public Map<String, String> hgetAll(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        Map<String, String> countMap = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            countMap = jedis.hgetAll(key);
        }finally {
            close(jedis);
        }
        return countMap;
    }

    /**
     * 判断指定的Key是否存在
     * @param key
     *          指定的Key
     * @return
     *          返回结果:true:存在 false:不存在
     */
    public boolean exists(String key){
        if(StringUtils.isBlank(key)){
            return false;
        }
        Jedis jedis = getJedis();
        boolean isExists = jedis.exists(key);
        close(jedis);
        return isExists;
    }

    /**
     * 添加锁处理
     * @param key
     *          健值
     * @param count
     *          尝试获取次数
     * @return
     *          是否成功获取到锁，
     *          true：成功
     *          false：失败
     */
    public synchronized boolean lock(String key, Integer count){
        if(StringUtils.isBlank(key)){
            return false;
        }
        if (count == null){
            count = 0;
        }
        Jedis jedis = getJedis();
        int i = 0;
        try {
            while (true) {
                Long setnx = jedis.setnx(key, "1");
                if (setnx.intValue() == 1) {
                    jedis.expire(key, 5);
                    return true;
                }
                if (i == count) {
                    return false;
                }
                i++;
                Thread.sleep(20);
            }
        } catch (Exception e) {
            return false;
        }finally {
            close(jedis);
        }
    }

    /**
     * 删除分布式锁
     * @param key
     *          删除的Key
     */
    public void unLock(String key){
        this.del(key);
    }

}
