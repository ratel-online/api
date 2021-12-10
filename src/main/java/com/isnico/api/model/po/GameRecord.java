package com.isnico.api.model.po;

import lombok.Data;
import org.nico.ourbatis.annotation.RenderPrimary;

@Data
public class GameRecord {

    @RenderPrimary
    private Long id;

    private Long gameId;

    private Long userId;

    private Long group;

    private Long score;

    private Long createTime;

    private Long updateTime;

    private Long deleted;

}
