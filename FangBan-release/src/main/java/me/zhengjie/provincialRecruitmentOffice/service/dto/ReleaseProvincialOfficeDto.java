package me.zhengjie.provincialRecruitmentOffice.service.dto;

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
public class ReleaseProvincialOfficeDto implements Serializable {

    /** 序号 */
    private Integer id;

    /** 发布省份 */
    private String province;

    /** 标题 */
    private String title;

    /** 信息类型 */
    private String categories;

    /** url地址 */
    private String url;

    /** 发布日期 */
    private Timestamp publishDate;

    /** 咨询电话 */
    private String phoneNumber;

    /** 浏览次数 */
    private Integer views;
}