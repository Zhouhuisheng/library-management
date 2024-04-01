package cn.huishengzhou.controller;

import cn.huishengzhou.common.Result;
import cn.huishengzhou.common.dto.LoginDTO;
import cn.huishengzhou.common.request.AdminPageRequest;
import cn.huishengzhou.common.request.LoginRequest;
import cn.huishengzhou.common.request.UserPageRequest;
import cn.huishengzhou.pojo.Admin;
import cn.huishengzhou.pojo.User;
import cn.huishengzhou.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    // 解决跨域问题
@RestController
@Api("管理员信息管理")
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    IAdminService adminService;

    @ApiOperation("获取管理员信息列表")
    @GetMapping
    public Result list() {
        List<Admin> admins = adminService.list();
        return Result.success(admins);
    }

    @ApiOperation("根据分页信息和模糊查询条件查询管理员信息列表")
    @GetMapping("/page")
    public Result page(AdminPageRequest adminPageRequest) {
        return Result.success(adminService.page(adminPageRequest));
    }

    @ApiOperation("新增管理员信息")
    @PostMapping
    public Result add(@RequestBody Admin admin) {
        return Result.success(adminService.add(admin));
    }

    @ApiOperation("更新管理员信息")
    @PutMapping
    public Result update(@RequestBody Admin admin) {
        return Result.success(adminService.update(admin));
    }

    @ApiOperation("根据id获取管理员信息")
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        return Result.success(adminService.selectById(id));
    }

    @ApiOperation("删除管理员信息")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(adminService.delete(id));
    }

    @ApiOperation("根据管理员信息登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        LoginDTO login = adminService.login(loginRequest);
        // 查询不到数据
        if (login == null) {
            return Result.error("用户名或密码错误");
        } else {
            return Result.success(adminService.login(loginRequest));
        }
    }
}
