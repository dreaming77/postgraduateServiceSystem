package me.zhengjie.speciality_academic.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-05-17
**/
@Data
public class SpecialityAcademicDto implements Serializable {

    /** 序号 */
    private Integer id;

    /** 专业名称 */
    private String specialityName;

    /** 专业代码 */
    private String code;

    /** 相关院校 */
    private String relativeColleges;

    /** 专业主页 */
    private String homepage;

    /** 类别 */
    private String category;

    /** 方向 */
    private String orientation;
}