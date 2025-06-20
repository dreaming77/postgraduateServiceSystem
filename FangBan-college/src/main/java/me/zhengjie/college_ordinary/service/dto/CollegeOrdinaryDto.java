package me.zhengjie.college_ordinary.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-05-16
**/
@Data
public class CollegeOrdinaryDto implements Serializable {

    /** 序号 */
    private Integer id;

    /** 院校名称 */
    private String collegeName;

    /** 省份 */
    private String province;

    /** 城市 */
    private String city;
}