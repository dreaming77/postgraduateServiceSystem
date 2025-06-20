package me.zhengjie.enrollmentUnit.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-05-01
**/
@Data
public class ReleaseEnrollmentUnitDto implements Serializable {

    /** 序号 */
    private Long id;

    /** 学院名称 */
    private String unit;

    /** 标题 */
    private String title;

    /** 链接地址 */
    private String url;

    /** 信息类型 */
    private String type;

    /** 发布日期 */
    private Timestamp date;

    /** 浏览人数 */
    private Integer browser;
}