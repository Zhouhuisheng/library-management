package cn.huishengzhou.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 模糊查询基类
 */
@Data
public class BaseRequest {
    @ApiModelProperty("分页页号")
    private Integer pageNum = 1;
    @ApiModelProperty("分页大小")
    private Integer pageSize = 5;
}
