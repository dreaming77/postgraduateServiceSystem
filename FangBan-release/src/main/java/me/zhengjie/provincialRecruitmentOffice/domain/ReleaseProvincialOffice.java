
package me.zhengjie.provincialRecruitmentOffice.domain;

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
@Table(name="release_provincial_office")
public class ReleaseProvincialOffice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "序号")
    private Integer id;

    @Column(name = "`province`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "发布省份")
    private String province;

    @Column(name = "`title`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "标题")
    private String title;

    @Column(name = "`categories`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "信息类型")
    private String categories;

    @Column(name = "`url`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "url地址")
    private String url;

    @Column(name = "`publish_date`")
    @UpdateTimestamp
    @ApiModelProperty(value = "发布日期")
    private Timestamp publishDate;

    @Column(name = "`phone_number`")
    @ApiModelProperty(value = "咨询电话")
    private String phoneNumber;

    @Column(name = "`views`")
    @ApiModelProperty(value = "浏览次数")
    private Integer views;

    public void copy(ReleaseProvincialOffice source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
