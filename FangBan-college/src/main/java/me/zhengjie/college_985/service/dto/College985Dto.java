package me.zhengjie.college_985.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-05-16
**/
@Data
public class College985Dto implements Serializable {

    /** 序号 */
    private Integer id;

    /** 院校名称 */
    private String collegeName;

    /** 院校排名 */
    private Integer range;

    /** 网站地址 */
    private String url;

    /** 省份 */
    private String province;

    /** 城市 */
    private String city;
}