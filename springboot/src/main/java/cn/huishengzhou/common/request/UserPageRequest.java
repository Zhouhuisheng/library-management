package cn.huishengzhou.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户分页和模糊查询类
 */
@ApiModel("用户分页和模糊查询类")
@Data
public class UserPageRequest extends BaseRequest {
    @ApiModelProperty("模糊查询条件（姓名）")
    private String name;
    @ApiModelProperty("模糊查询条件（联系方式）")
    private String phone;

}
