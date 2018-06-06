package com.xxw.service.impl;

import com.xxw.dao.UserDao;
import com.xxw.pojo.User;
import com.xxw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "IUserService")
public class UserServiceImpl  implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name = "UserDao")
    private UserDao dao;

    /**
     * 这里模拟一下
     *  1、先去redis中读取数据
     *  2.1、如果redis存在数据则直接返回
     *  2.2、如果redis中不存在需要的数据，则去数据库中查询，后将数据存储到redis中再返回数据
     * @return
     * @throws Exception
     */
    @Override
    public List<User> getUserList(String id)throws Exception {

        List<User> listUser = null;  // 存储用户信息
        String h = "userRedisCache"; // hash key

        /*
         * 判断参数ID是否为空, 查询redis缓存中用户信息：
         *   ID为空 - 》 查询全部用户信息
         *   ID不为空-》 根据用户ID查询用户信息
         */
        if(id == null || "".equals(id)){
            listUser= redisTemplate.opsForHash().values(h);
        }else{
            listUser = (List<User>)redisTemplate.opsForHash().get(h, id);
        }

        // 判断listUser是否为空：listUser为空 - 》 去数据库中获取指定用户信息，后将信息存入redis缓存
        if(listUser == null || listUser.size() == 0){
            listUser = dao.findUserListById(id);
            for (User user : listUser) {
                redisTemplate.opsForHash().put(h, user.getId(), user);
            }
        }

        return listUser;
    }

    /**
     * 这里模拟一下
     *  1、先去redis中读取数据
     *  2.1、如果redis存在数据则直接返回
     *  2.2、如果redis中不存在需要的数据，则去数据库中查询，后将数据存储到redis中再返回数据
     * @return
     * @throws Exception
     */
    @Override
    public List<String> getUserName() throws Exception {
       /* // 调用RedisTempUtil工具类
        Object name = get("userName");
        if(name != null){
            return name.toString();
        }else{
            // 去数据库查询用户名
            String userName = "rose"; // 此处模拟
            // 将数据存到redis
            set("userName", userName);
            return userName;
        }*/
       return  null;
    }

    /**
     * 缓存字符串
     * @param key
     * @param value
     * @throws Exception
     */
    public void set(Object key, Object value) throws Exception{
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 读取字符串
     * @param key
     * @return
     */
    public Object get(Object key) throws Exception{
        if(redisTemplate == null){
            System.out.println("redisTemplate是空的啊啊啊啊啊啊啊啊");
        }
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 缓存HashMap
     * @param hkey
     * @param key
     * @param value
     * @throws Exception
     */
    public void hset(Object hkey, Object key, Object value) throws Exception{
        redisTemplate.opsForHash().put(hkey, key, value);
    }

    /**
     * 读取HashMap
     * @param hkey
     * @param key
     * @return
     * @throws Exception
     */
    public Object hget(Object hkey, Object key)throws Exception{
        return redisTemplate.opsForHash().get(hkey, key);
    }


    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

}
