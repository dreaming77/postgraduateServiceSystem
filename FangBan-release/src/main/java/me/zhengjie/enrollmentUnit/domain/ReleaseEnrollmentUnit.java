
package me.zhengjie.enrollmentUnit.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-05-01
**/
@Entity
@Data
@Table(name="release_enrollment_unit")
public class ReleaseEnrollmentUnit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "序号")
    private Long id;

    @Column(name = "`unit`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "学院名称")
    private String unit;

    @Column(name = "`title`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "标题")
    private String title;

    @Column(name = "`url`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "链接地址")
    private String url;

    @Column(name = "`type`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "信息类型")
    private String type;

    @Column(name = "`date`")
    @UpdateTimestamp
    @ApiModelProperty(value = "发布日期")
    private Timestamp date;

    @Column(name = "`browser`")
    @ApiModelProperty(value = "浏览人数")
    private Integer browser;

    public void copy(ReleaseEnrollmentUnit source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
