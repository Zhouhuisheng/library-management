package cn.huishengzhou.service.impl;

import cn.huishengzhou.common.RedisUtil;
import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.mapper.BookMapper;
import cn.huishengzhou.mapper.CategoryMapper;
import cn.huishengzhou.pojo.Book;
import cn.huishengzhou.pojo.Category;
import cn.huishengzhou.service.IBookService;
import cn.huishengzhou.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Book> list() {
        // 尝试从缓存中获取分类列表
        List<Book> bookList = (List<Book>) redisUtil.get("bookList");
        if (bookList != null) {
            return bookList;
        } else {
            bookList = bookMapper.list();
            // 将结果写入缓存
            redisUtil.set("bookList", bookList);
            return bookList;
        }
    }

    @Override
    public List<Book> listByStatus(Integer status) {
        return bookMapper.listByStatus(status);
    }

    @Override
    public Object page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Book> books = bookMapper.listByCondition(baseRequest);
        return new PageInfo<>(books);
    }

    @Override
    public Integer add(Book book) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        book.setCreateTime(currentTime);
        book.setUpdateTime(currentTime);

        Integer result = bookMapper.add(book);

        // 清除缓存
        redisUtil.remove("bookList");

        return result;
    }

    @Override
    public Book selectById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public Integer update(Book book) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        book.setUpdateTime(currentTime);
        Integer result = bookMapper.update(book);

        // 清除缓存
        redisUtil.remove("bookList");

        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Integer result = bookMapper.delete(id);
        // 清除缓存
        redisUtil.remove("bookList");
        return result;
    }
}
