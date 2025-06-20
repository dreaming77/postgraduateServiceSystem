
package me.zhengjie.policy.domestic.domain;

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
* @date 2023-05-29
**/
@Entity
@Data
@Table(name="policy_domestic")
public class PolicyDomestic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "序号")
    private Integer id;

    @Column(name = "`title`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "标题")
    private String title;

    @Column(name = "`origin_resource`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "信息来源")
    private String originResource;

    @Column(name = "`url`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "网站地址")
    private String url;

    @Column(name = "`publish_date`")
    @UpdateTimestamp
    @ApiModelProperty(value = "发布日期")
    private Timestamp publishDate;

    public void copy(PolicyDomestic source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
