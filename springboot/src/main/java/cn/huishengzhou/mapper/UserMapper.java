package cn.huishengzhou.mapper;

import cn.huishengzhou.common.request.UserPageRequest;
import cn.huishengzhou.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

//    @Select("select * from user")
    List<User> list();

    List<User> listByCondition(UserPageRequest userPageRequest);

    Integer add(User user);

    User selectById(Integer id);

    Integer update(User user);

    Integer delete(Integer id);
}
