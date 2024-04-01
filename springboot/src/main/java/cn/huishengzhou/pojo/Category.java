package cn.huishengzhou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("图书分类信息实体类")
@Data
public class Category implements Serializable {
    @ApiModelProperty("图书分类id（不需要填，自增）")
    private Integer id;
    @ApiModelProperty("图书分类名")
    private String name;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("图书分类编号")
    private String pid;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("更新时间")
    private String updateTime;
}
