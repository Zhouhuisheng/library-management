package cn.huishengzhou.service.impl;

import cn.huishengzhou.common.RedisUtil;
import cn.huishengzhou.common.dto.LoginDTO;
import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.common.request.LoginRequest;
import cn.huishengzhou.common.request.UserPageRequest;
import cn.huishengzhou.mapper.AdminMapper;
import cn.huishengzhou.pojo.Admin;
import cn.huishengzhou.pojo.Category;
import cn.huishengzhou.service.IAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Admin> list() {
        // 尝试从缓存中获取分类列表
        List<Admin> adminList = (List<Admin>) redisUtil.get("adminList");
        if (adminList != null) {
            return adminList;
        } else {
            adminList = adminMapper.list();
            // 将结果写入缓存
            redisUtil.set("categoryList", adminList);
            return adminList;
        }
    }

    @Override
    public Object page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(baseRequest);
        return new PageInfo<>(admins);
    }

    @Override
    public Integer add(Admin admin) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        admin.setCreateTime(currentTime);
        admin.setUpdateTime(currentTime);

        Integer result = adminMapper.add(admin);

        // 清除缓存
        redisUtil.remove("adminList");

        return result;
    }

    @Override
    public Admin selectById(Integer id) {
        return adminMapper.selectById(id);
    }

    @Override
    public Integer update(Admin admin) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        admin.setUpdateTime(currentTime);
        Integer result = adminMapper.update(admin);

        // 清除缓存
        redisUtil.remove("adminList");

        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Integer result = adminMapper.delete(id);
        // 清除缓存
        redisUtil.remove("adminList");
        return result;
    }

    @Override
    public LoginDTO login(LoginRequest loginRequest) {
        try {
            Admin admin = adminMapper.getByUsernameAndPassword(loginRequest);
            LoginDTO loginDTO = new LoginDTO();
            BeanUtils.copyProperties(admin, loginDTO);  // 复制相同名的属性值
            return loginDTO;
        } catch (Exception e) {
            log.error("登录出现异常", e);
            return null;
        }
    }
}
