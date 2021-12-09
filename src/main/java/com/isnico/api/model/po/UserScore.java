package com.isnico.api.model.po;

import com.isnico.api.enums.UserScoreTypeEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.nico.ourbatis.annotation.RenderPrimary;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Eagga_Lo on 2021/12/8 15:33
 *
 * @author Eagga_Lo
 */
@ApiModel(value = "user_score")
@Data
public class UserScore implements Serializable {
    /**
     * 主键
     */
    @RenderPrimary
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 类型
     *
     * @see UserScoreTypeEnums
     */
    @ApiModelProperty(value = "类型")
    private Integer type;

    /**
     * 积分数量
     */
    @ApiModelProperty(value = "积分数量")
    private Integer score;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String desc;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}
