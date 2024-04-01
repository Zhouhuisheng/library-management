package cn.huishengzhou.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 管理员信息分页和模糊查询类
 */
@ApiModel("管理员信息分页和模糊查询类")
@Data
public class AdminPageRequest extends BaseRequest {
    @ApiModelProperty("模糊查询条件（用户名）")
    private String userName;
    @ApiModelProperty("模糊查询条件（邮箱）")
    private String email;

}
