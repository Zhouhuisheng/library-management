package cn.huishengzhou.service;

import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.pojo.Book;
import cn.huishengzhou.pojo.Category;

import java.util.List;

public interface IBookService {
    List<Book> list();

    List<Book> listByStatus(Integer status);

    Object page(BaseRequest baseRequest);

    Integer add(Book book);

    Integer update(Book book);

    Book selectById(Integer id);

    Integer delete(Integer id);
}
