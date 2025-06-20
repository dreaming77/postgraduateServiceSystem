
package me.zhengjie.speciality_professional.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-05-17
**/
@Entity
@Data
@Table(name="speciality_professional")
public class SpecialityProfessional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "序号")
    private Integer id;

    @Column(name = "`speciality_name`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "专业名称")
    private String specialityName;

    @Column(name = "`code`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "专业代码")
    private String code;

    @Column(name = "`relative_colleges`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "相关院校")
    private String relativeColleges;

    @Column(name = "`homepage`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "专业主页")
    private String homepage;

    @Column(name = "`category`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "类别")
    private String category;

    @Column(name = "`orientation`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "方向")
    private String orientation;

    public void copy(SpecialityProfessional source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
