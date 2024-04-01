package cn.huishengzhou.controller;

import cn.huishengzhou.common.Result;
import cn.huishengzhou.common.request.BookPageRequest;
import cn.huishengzhou.common.request.BorrowPageRequest;
import cn.huishengzhou.pojo.Book;
import cn.huishengzhou.pojo.Borrow;
import cn.huishengzhou.service.IBookService;
import cn.huishengzhou.service.IBorrowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    // 解决跨域问题
@RestController
@Api("图书借用信息管理")
@RequestMapping("/borrows")
public class BorrowController {
    @Autowired
    IBorrowService borrowService;

    @ApiOperation("获取借书信息列表")
    @GetMapping
    public Result list() {
        List<Borrow> borrows = borrowService.list();
        return Result.success(borrows);
    }

    @ApiOperation("根据分页信息和模糊查询条件查询借书信息列表")
    @GetMapping("/page")
    public Result page(BorrowPageRequest borrowPageRequest) {
        return Result.success(borrowService.page(borrowPageRequest));
    }

    @ApiOperation("新增借书信息")
    @PostMapping
    public Result add(@RequestBody Borrow borrow) {
        return Result.success(borrowService.add(borrow));
    }

    @ApiOperation("更新借书信息")
    @PutMapping
    public Result update(@RequestBody Borrow borrow) {
        return Result.success(borrowService.update(borrow));
    }

    @ApiOperation("根据id获取借书信息")
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        return Result.success(borrowService.selectById(id));
    }

    @ApiOperation("还书")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(borrowService.delete(id));
    }
}
