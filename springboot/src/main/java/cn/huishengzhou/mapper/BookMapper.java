package cn.huishengzhou.mapper;

import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.pojo.Book;
import cn.huishengzhou.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

//    @Select("select * from user")
    List<Book> list();

    List<Book> listByStatus(Integer status);

    List<Book> listByCondition(BaseRequest baseRequest);

    Integer add(Book book);

    Book selectById(Integer id);

    Integer update(Book book);

    Integer delete(Integer id);
}
