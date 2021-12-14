package com.isnico.api.model.po;

import lombok.Data;
import org.nico.ourbatis.annotation.RenderPrimary;

import java.util.Date;

@Data
public class Game {

    @RenderPrimary
    private Long id;

    /**
     * GameTypeEnums
     */
    private Integer type;

    private Integer players;

    private Long room_id;

    private Date begin_time;

    private Date end_time;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;
}
