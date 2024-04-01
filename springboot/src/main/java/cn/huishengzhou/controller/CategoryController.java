package cn.huishengzhou.controller;

import cn.huishengzhou.common.Result;
import cn.huishengzhou.common.dto.LoginDTO;
import cn.huishengzhou.common.request.AdminPageRequest;
import cn.huishengzhou.common.request.CategoryPageRequest;
import cn.huishengzhou.common.request.LoginRequest;
import cn.huishengzhou.pojo.Admin;
import cn.huishengzhou.pojo.Category;
import cn.huishengzhou.service.IAdminService;
import cn.huishengzhou.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    // 解决跨域问题
@RestController
@Api("图书分类信息管理")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @ApiOperation("获取图书分类信息列表")
    @GetMapping
    public Result list() {
        List<Category> categories = categoryService.list();
        return Result.success(categories);
    }

    @ApiOperation("根据分页信息和模糊查询条件查询图书分类信息列表")
    @GetMapping("/page")
    public Result page(CategoryPageRequest categoryPageRequest) {
        return Result.success(categoryService.page(categoryPageRequest));
    }

    @ApiOperation("新增图书分类信息")
    @PostMapping
    public Result add(@RequestBody Category category) {
        return Result.success(categoryService.add(category));
    }

    @ApiOperation("更新图书分类信息")
    @PutMapping
    public Result update(@RequestBody Category category) {
        return Result.success(categoryService.update(category));
    }

    @ApiOperation("根据id获取图书分类信息")
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        return Result.success(categoryService.selectById(id));
    }

    @ApiOperation("删除图书分类信息")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(categoryService.delete(id));
    }
}
