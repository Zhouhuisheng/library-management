package cn.huishengzhou.mapper;

import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.common.request.LoginRequest;
import cn.huishengzhou.pojo.Admin;
import cn.huishengzhou.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

//    @Select("select * from user")
    List<Category> list();

    List<Category> listByCondition(BaseRequest baseRequest);

    Integer add(Category category);

    Category selectById(Integer id);

    Integer update(Category category);

    Integer delete(Integer id);
}
