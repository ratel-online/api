package com.isnico.api.model.po;

import lombok.Data;
import org.nico.ourbatis.annotation.RenderPrimary;

import java.util.Date;

@Data
public class GameRecord {

    @RenderPrimary
    private Long id;

    private Long gameId;

    private Long userId;

    private Integer group;

    private Integer score;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

}
