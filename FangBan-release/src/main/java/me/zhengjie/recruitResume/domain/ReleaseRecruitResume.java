
package me.zhengjie.recruitResume.domain;

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
* @date 2023-05-02
**/
@Entity
@Data
@Table(name="release_recruit_resume")
public class ReleaseRecruitResume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "序号")
    private Integer id;

    @Column(name = "`college`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "院校名称")
    private String college;

    @Column(name = "`resume_title`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "招生简章")
    private String resumeTitle;

    @Column(name = "`url`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "url地址")
    private String url;

    @Column(name = "`resume_publish_date`")
    @UpdateTimestamp
    @ApiModelProperty(value = "发布时间")
    private Timestamp resumePublishDate;

    @Column(name = "`contact_phone_number`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "联系单位电话")
    private String contactPhoneNumber;

    @Column(name = "`broswer`")
    @ApiModelProperty(value = "浏览次数")
    private Integer broswer;

    public void copy(ReleaseRecruitResume source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
