package cn.huishengzhou.mapper;

import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.pojo.Book;
import cn.huishengzhou.pojo.Borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BorrowMapper {

//    @Select("select * from user")
    List<Borrow> list();

    List<Borrow> listByCondition(BaseRequest baseRequest);

    Integer add(Borrow borrow);

    Borrow selectById(Integer id);

    Integer update(Borrow borrow);

    Integer delete(Integer id);
}
