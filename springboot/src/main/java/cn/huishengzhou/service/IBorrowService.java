package cn.huishengzhou.service;

import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.pojo.Book;
import cn.huishengzhou.pojo.Borrow;

import java.util.List;

public interface IBorrowService {
    List<Borrow> list();

    Object page(BaseRequest baseRequest);

    Integer add(Borrow borrow);

    Integer update(Borrow borrow);

    Borrow selectById(Integer id);

    Integer delete(Integer id);
}
