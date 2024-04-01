package cn.huishengzhou.controller;

import cn.huishengzhou.common.Result;
import cn.huishengzhou.common.request.UserPageRequest;
import cn.huishengzhou.pojo.User;
import cn.huishengzhou.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    // 解决跨域问题
@RestController
@Api("用户信息管理")
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @ApiOperation("获取用户列表")
    @GetMapping
    public Result list() {
        List<User> users = userService.list();
        return Result.success(users);
    }

    @ApiOperation("根据id获取用户信息")
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        return Result.success(userService.selectById(id));
    }

    @ApiOperation("根据分页信息和模糊查询条件查询用户列表")
    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest) {
        return Result.success(userService.page(userPageRequest));
    }

    @ApiOperation("新增用户信息")
    @PostMapping
    public Result add(@RequestBody User user) {
        return Result.success(userService.add(user));
    }

    @ApiOperation("更新用户信息")
    @PutMapping
    public Result update(@RequestBody User user) {
        return Result.success(userService.update(user));
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(userService.delete(id));
    }
}
