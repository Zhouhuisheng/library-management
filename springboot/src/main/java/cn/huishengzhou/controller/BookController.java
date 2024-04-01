package cn.huishengzhou.controller;

import cn.huishengzhou.common.Result;
import cn.huishengzhou.common.request.BookPageRequest;
import cn.huishengzhou.common.request.CategoryPageRequest;
import cn.huishengzhou.pojo.Book;
import cn.huishengzhou.pojo.Category;
import cn.huishengzhou.service.IBookService;
import cn.huishengzhou.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    // 解决跨域问题
@RestController
@Api("图书信息管理")
@RequestMapping("/books")
public class BookController {
    @Autowired
    IBookService bookService;

    @ApiOperation("获取图书信息列表")
    @GetMapping
    public Result list() {
        List<Book> books = bookService.list();
        return Result.success(books);
    }

    @ApiOperation("查询可借图书列表")
    @GetMapping("/listByStatus/{status}")
    public Result listByStatus(@PathVariable Integer status) {
        List<Book> books = bookService.listByStatus(status);
        return Result.success(books);
    }

    @ApiOperation("根据分页信息和模糊查询条件查询图书信息列表")
    @GetMapping("/page")
    public Result page(BookPageRequest bookPageRequest) {
        return Result.success(bookService.page(bookPageRequest));
    }

    @ApiOperation("新增图书信息")
    @PostMapping
    public Result add(@RequestBody Book book) {
        return Result.success(bookService.add(book));
    }

    @ApiOperation("更新图书信息")
    @PutMapping
    public Result update(@RequestBody Book book) {
        return Result.success(bookService.update(book));
    }

    @ApiOperation("根据id获取图书信息")
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        return Result.success(bookService.selectById(id));
    }

    @ApiOperation("删除图书信息")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(bookService.delete(id));
    }
}
