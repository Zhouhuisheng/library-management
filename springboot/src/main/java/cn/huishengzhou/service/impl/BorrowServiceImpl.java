package cn.huishengzhou.service.impl;

import cn.huishengzhou.common.RedisUtil;
import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.mapper.BookMapper;
import cn.huishengzhou.mapper.BorrowMapper;
import cn.huishengzhou.pojo.Book;
import cn.huishengzhou.pojo.Borrow;
import cn.huishengzhou.pojo.Category;
import cn.huishengzhou.service.IBookService;
import cn.huishengzhou.service.IBorrowService;
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
public class BorrowServiceImpl implements IBorrowService {

    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Borrow> list() {
        // 尝试从缓存中获取借书记录列表
        List<Borrow> borrowList = (List<Borrow>) redisUtil.get("borrowList");
        if (borrowList != null) {
            return borrowList;
        } else {
            borrowList = borrowMapper.list();
            // 将结果写入缓存
            redisUtil.set("borrowList", borrowList);
            return borrowList;
        }
    }

    @Override
    public Object page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Borrow> borrows = borrowMapper.listByCondition(baseRequest);
        return new PageInfo<>(borrows);
    }

    @Override
    public Integer add(Borrow borrow) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        borrow.setCreateTime(currentTime);
        borrow.setUpdateTime(currentTime);

        Integer result = borrowMapper.add(borrow);
        // 设置图书状态
        Book book = bookMapper.selectById(borrow.getBookId());
        book.setStatus(0);

        bookMapper.update(book);

        // 清除缓存
        redisUtil.remove("borrowList");
        redisUtil.remove("bookList");

        return result;
    }

    @Override
    public Borrow selectById(Integer id) {
        return borrowMapper.selectById(id);
    }

    @Override
    public Integer update(Borrow borrow) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        borrow.setUpdateTime(currentTime);
        Integer result = borrowMapper.update(borrow);

        // 清除缓存
        redisUtil.remove("borrowList");

        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Borrow borrow = borrowMapper.selectById(id);
        Integer bookId = borrow.getBookId();
        Book book = bookMapper.selectById(bookId);
        book.setStatus(1);
        bookMapper.update(book);

        // 清除缓存
        redisUtil.remove("categoryList");
        redisUtil.remove("borrowList");

        return borrowMapper.delete(id);
    }
}
