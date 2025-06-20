package me.zhengjie.feedback.service.dto;

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
public class ConsultFeedbackDto implements Serializable {

    /** 序号 */
    private Integer id;

    /** 用户名 */
    private String username;

    /** 反馈时间 */
    private Timestamp submitDate;

    /** 用户联系方式 */
    private String contact;

    /** 反馈内容 */
    private String feedbackContent;

    /** 已处理 */
    private String processed;

    /** 处理客服 */
    private String customer;

    /** 性别 */
    private String sex;
}