package cn.huishengzhou.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 图书分类信息分页和模糊查询类
 */
@ApiModel("图书分类分页和模糊查询类")
@Data
public class CategoryPageRequest extends BaseRequest {
    @ApiModelProperty("模糊查询条件（分类名）")
    private String name;

}
