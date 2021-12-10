package com.isnico.api.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.nico.ourbatis.annotation.RenderPrimary;

@Data
public class GameRecordListResp {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("游戏id")
    private Long gameId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("队伍组")
    private Long group;

    @ApiModelProperty("积分扣减情况")
    private Long score;

    @ApiModelProperty("创建时间")
    private Long createTime;

    @ApiModelProperty("更新时间")
    private Long updateTime;

    @ApiModelProperty("是否删除")
    private Long deleted;
}
