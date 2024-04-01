package cn.huishengzhou.service;

import cn.huishengzhou.common.dto.LoginDTO;
import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.common.request.LoginRequest;
import cn.huishengzhou.common.request.UserPageRequest;
import cn.huishengzhou.pojo.Admin;
import cn.huishengzhou.pojo.User;

import java.util.List;

public interface IAdminService {
    List<Admin> list();

    Object page(BaseRequest baseRequest);

    Integer add(Admin admin);

    Integer update(Admin admin);

    Admin selectById(Integer id);

    Integer delete(Integer id);

    LoginDTO login(LoginRequest loginRequest);
}
