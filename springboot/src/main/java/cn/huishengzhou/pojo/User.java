package cn.huishengzhou.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("用户实体类")
public class User implements Serializable {
    @ApiModelProperty("用户id（不需要填，自增）")
    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("联系方式")
    private String phone;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("创建日期")
    private String createTime;
    @ApiModelProperty("更新日期")
    private String updateTime;
}
