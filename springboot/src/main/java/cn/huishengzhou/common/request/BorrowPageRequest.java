package cn.huishengzhou.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 借书信息分页和模糊查询类
 */
@ApiModel("借书信息分页和模糊查询类")
@Data
public class BorrowPageRequest extends BaseRequest {
    @ApiModelProperty("模糊查询条件（图书名）")
    private String bookName;
    @ApiModelProperty("模糊查询条件（用户名）")
    private String userName;

}
