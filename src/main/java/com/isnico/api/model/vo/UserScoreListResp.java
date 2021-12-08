package com.isnico.api.model.vo;

import com.isnico.api.enums.UserScoreTypeEnums;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Eagga_Lo on 2021/12/8 15:54
 *
 * @author Eagga_Lo
 */
@Data
public class UserScoreListResp {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("时间")
    private LocalDateTime dateTime;

    /**
     * 类型
     *
     * @see UserScoreTypeEnums
     */
    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "积分数量")
    private Integer score;

    @ApiModelProperty(value = "描述")
    private String desc;

    @ApiModelProperty(value = "备注")
    private String remark;


}
