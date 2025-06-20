package me.zhengjie.gen.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-04-19
**/
@Data
public class ConsultListDto implements Serializable {

    /** id编号 */
    private Integer id;

    /** 发布者信息 */
    private String username;

    /** 添加时间 */
    private Timestamp addtime;

    /** 咨询标题 */
    private String title;

    /** 咨询内容 */
    private String content;
}