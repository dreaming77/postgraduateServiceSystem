
package me.zhengjie.gen.domain;

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
* @date 2023-04-19
**/
@Entity
@Data
@Table(name="consult_list")
public class ConsultList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "id编号")
    private Integer id;

    @Column(name = "`username`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "发布者信息")
    private String username;

    @Column(name = "`addtime`")
    @UpdateTimestamp
    @ApiModelProperty(value = "添加时间")
    private Timestamp addtime;

    @Column(name = "`title`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "咨询标题")
    private String title;

    @Column(name = "`content`")
    @ApiModelProperty(value = "咨询内容")
    private String content;

    public void copy(ConsultList source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
