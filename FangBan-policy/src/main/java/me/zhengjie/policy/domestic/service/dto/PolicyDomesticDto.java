package me.zhengjie.policy.domestic.service.dto;

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
public class PolicyDomesticDto implements Serializable {

    /** 序号 */
    private Integer id;

    /** 标题 */
    private String title;

    /** 信息来源 */
    private String originResource;

    /** 网站地址 */
    private String url;

    /** 发布日期 */
    private Timestamp publishDate;
}