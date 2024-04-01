package cn.huishengzhou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 借书类
 */
@ApiModel("借书信息实体类")
@Data
public class Borrow implements Serializable {
    @ApiModelProperty("借书信息id（不需要填，自增）")
    private Integer id;
    @ApiModelProperty("图书id")
    private Integer bookId;
    @ApiModelProperty("图书名")
    private String bookName;
    @ApiModelProperty("借书用户id")
    private Integer userId;
    @ApiModelProperty("借书用户用户名")
    private String userName;
    @ApiModelProperty("创建日期")
    private String createTime;
    @ApiModelProperty("更新日期")
    private String updateTime;
}
