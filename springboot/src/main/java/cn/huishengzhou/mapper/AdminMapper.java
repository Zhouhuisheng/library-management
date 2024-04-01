package cn.huishengzhou.mapper;

import cn.huishengzhou.common.dto.LoginDTO;
import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.common.request.LoginRequest;
import cn.huishengzhou.common.request.UserPageRequest;
import cn.huishengzhou.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

//    @Select("select * from user")
    List<Admin> list();

    List<Admin> listByCondition(BaseRequest baseRequest);

    Integer add(Admin admin);

    Admin selectById(Integer id);

    Integer update(Admin admin);

    Integer delete(Integer id);

    Admin getByUsernameAndPassword(LoginRequest loginRequest);
}
