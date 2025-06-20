
package me.zhengjie.machine.domain;

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
@Table(name="consult_machine")
public class ConsultMachine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "序号")
    private Integer id;

    @Column(name = "`categories`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "咨询类型")
    private String categories;

    @Column(name = "`user_information`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "用户信息")
    private String userInformation;

    @Column(name = "`title`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "咨询标题")
    private String title;

    @Column(name = "`answer`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "对应解答")
    private String answer;

    @Column(name = "`issolve`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "已解决")
    private String issolve;

    @Column(name = "`date`")
    @UpdateTimestamp
    @ApiModelProperty(value = "解答日期")
    private Timestamp date;

    @Column(name = "`satisfaction`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "满意度")
    private String satisfaction;

    public void copy(ConsultMachine source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
