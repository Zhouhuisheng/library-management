package cn.huishengzhou.service.impl;

import cn.huishengzhou.common.RedisUtil;
import cn.huishengzhou.common.dto.LoginDTO;
import cn.huishengzhou.common.request.BaseRequest;
import cn.huishengzhou.common.request.LoginRequest;
import cn.huishengzhou.mapper.AdminMapper;
import cn.huishengzhou.mapper.CategoryMapper;
import cn.huishengzhou.pojo.Admin;
import cn.huishengzhou.pojo.Category;
import cn.huishengzhou.pojo.User;
import cn.huishengzhou.service.IAdminService;
import cn.huishengzhou.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Category> list() {
        // 尝试从缓存中获取分类列表
        List<Category> categoryList = (List<Category>) redisUtil.get("categoryList");
        if (categoryList != null) {
            return categoryList;
        } else {
            categoryList = categoryMapper.list();
            // 将结果写入缓存
            redisUtil.set("categoryList", categoryList);
            return categoryList;
        }
    }

    @Override
    public Object page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Category> categories = categoryMapper.listByCondition(baseRequest);
        return new PageInfo<>(categories);
    }

    @Override
    public Integer add(Category category) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        category.setCreateTime(currentTime);
        category.setUpdateTime(currentTime);

        Integer result = categoryMapper.add(category);

        // 清除缓存
        redisUtil.remove("categoryList");

        return result;
    }

    @Override
    public Category selectById(Integer id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public Integer update(Category category) {
        // 处理时间
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        category.setUpdateTime(currentTime);
        Integer result = categoryMapper.update(category);

        // 清除缓存
        redisUtil.remove("categoryList");

        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Integer result = categoryMapper.delete(id);
        // 清除缓存
        redisUtil.remove("categoryList");
        return result;
    }
}
