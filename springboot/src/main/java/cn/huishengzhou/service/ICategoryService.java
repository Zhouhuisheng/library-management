package cn.huishengzhou.service;

import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.common.request.UserPageRequest;
import cn.huishengzhou.pojo.Category;
import cn.huishengzhou.pojo.User;

import java.util.List;

public interface ICategoryService {
    List<Category> list();

    Object page(BaseRequest baseRequest);

    Integer add(Category category);

    Integer update(Category category);

    Category selectById(Integer id);

    Integer delete(Integer id);
}
