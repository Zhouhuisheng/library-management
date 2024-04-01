package cn.huishengzhou.service.impl;

import cn.huishengzhou.common.RedisUtil;
import cn.huishengzhou.common.request.UserPageRequest;
import cn.huishengzhou.mapper.UserMapper;
import cn.huishengzhou.pojo.User;
import cn.huishengzhou.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<User> list() {
        // 尝试从缓存中获取用户列表
        List<User> userList = (List<User>) redisUtil.get("userList");
        if (userList != null) {
            return userList;
        } else {
            userList = userMapper.list();
            // 将结果写入缓存
            redisUtil.set("userList", userList);
            return userList;
        }
//        return usermapper.list();
    }

    @Override
    public Object page(UserPageRequest userPageRequest) {
        PageHelper.startPage(userPageRequest.getPageNum(), userPageRequest.getPageSize());
        List<User> users = userMapper.listByCondition(userPageRequest);
        return new PageInfo<>(users);
    }

    @Override
    public Integer add(User user) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        user.setCreateTime(currentTime);
        user.setUpdateTime(currentTime);

        Integer result = userMapper.add(user);

        // 清除缓存
        redisUtil.remove("userList");

        return result;
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer update(User user) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        user.setUpdateTime(currentTime);
        Integer result = userMapper.update(user);

        // 清除缓存
        redisUtil.remove("userList");

        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Integer result = userMapper.delete(id);
        // 清除缓存
        redisUtil.remove("userList");
        return result;
    }
}
