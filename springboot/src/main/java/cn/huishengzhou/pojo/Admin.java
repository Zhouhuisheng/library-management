package cn.huishengzhou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("管理员信息实体类")
@Data
public class Admin implements Serializable {
    @ApiModelProperty("管理员id（不需要填，自增")
    private Integer id;
    @ApiModelProperty("管理员用户名")
    private String userName;
    @ApiModelProperty("管理员密码")
    private String password;
    @ApiModelProperty("管理员邮箱")
    private String email;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("更新时间")
    private String updateTime;
}
