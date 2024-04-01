package cn.huishengzhou.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 图书信息分页和模糊查询类
 */
@ApiModel("图书信息分页和模糊查询类")
@Data
public class BookPageRequest extends BaseRequest {
    @ApiModelProperty("模糊查询条件（图书名）")
    private String name;
    @ApiModelProperty("模糊查询条件（作者）")
    private String author;

}
