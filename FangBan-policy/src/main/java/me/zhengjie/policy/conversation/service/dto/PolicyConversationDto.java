package me.zhengjie.policy.conversation.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-05-29
**/
@Data
public class PolicyConversationDto implements Serializable {

    /** 序号 */
    private Integer id;

    /** 标题 */
    private String title;

    /** 信息来源 */
    private String originResource;

    /** 发布日期 */
    private Timestamp date;

    /** 访谈内容 */
    private String content;
}