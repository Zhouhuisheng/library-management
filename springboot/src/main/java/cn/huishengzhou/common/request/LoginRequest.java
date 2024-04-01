package cn.huishengzhou.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录信息类
 */
@ApiModel("登录信息实体类")
@Data
public class LoginRequest {
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("密码")
    private String password;
}
