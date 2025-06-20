
package me.zhengjie.feedback.domain;

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
* @date 2023-04-27
**/
@Entity
@Data
@Table(name="consult_feedback")
public class ConsultFeedback implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "序号")
    private Integer id;

    @Column(name = "`username`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "用户名")
    private String username;

    @Column(name = "`submit_date`")
    @UpdateTimestamp
    @ApiModelProperty(value = "反馈时间")
    private Timestamp submitDate;

    @Column(name = "`contact`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "用户联系方式")
    private String contact;

    @Column(name = "`feedback_content`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "反馈内容")
    private String feedbackContent;

    @Column(name = "`processed`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "已处理")
    private String processed;

    @Column(name = "`customer`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "处理客服")
    private String customer;

    @Column(name = "`sex`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "性别")
    private String sex;

    public void copy(ConsultFeedback source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
