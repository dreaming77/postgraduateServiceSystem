
package me.zhengjie.service.domain;

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
@Table(name="consult_service")
public class ConsultService implements Serializable {

    @Id
    @Column(name = "`manual_id`")
    @ApiModelProperty(value = "客服编号")
    private Integer manualId;

    @Column(name = "`serviser`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "客服")
    private String serviser;

    @Column(name = "`time_long`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "时长")
    private String timeLong;

    @Column(name = "`service_date`")
    @UpdateTimestamp
    @ApiModelProperty(value = "咨询日期")
    private Timestamp serviceDate;

    @Column(name = "`satisfaction`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "服务满意程度")
    private String satisfaction;

    @Column(name = "`content`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "咨询内容")
    private String content;

    public void copy(ConsultService source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
