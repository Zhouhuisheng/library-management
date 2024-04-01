package cn.huishengzhou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 图书类
 */
@ApiModel("图书信息实体类")
@Data
public class Book implements Serializable {
    @ApiModelProperty("图书id（不需要填，自增）")
    private Integer id;
    @ApiModelProperty("图书名")
    private String name;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("图书分类")
    private String category;
    @ApiModelProperty("图书状态（默认1可借）")
    private Integer status = 1;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("更新时间")
    private String updateTime;
}
