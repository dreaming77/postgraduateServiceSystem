package me.zhengjie.service.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-04-27
**/
@Data
public class ConsultServiceDto implements Serializable {

    /** 客服编号 */
    private Integer manualId;

    /** 客服 */
    private String serviser;

    /** 时长 */
    private String timeLong;

    /** 咨询日期 */
    private Timestamp serviceDate;

    /** 服务满意程度 */
    private String satisfaction;

    /** 咨询内容 */
    private String content;
}