package cn.huishengzhou.service;

import cn.huishengzhou.common.request.UserPageRequest;
import cn.huishengzhou.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> list();

    Object page(UserPageRequest userPageRequest);

    Integer add(User user);

    Integer update(User user);

    User selectById(Integer id);

    Integer delete(Integer id);
}
