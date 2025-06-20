
package me.zhengjie.college_ordinary.domain;

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
* @date 2023-05-16
**/
@Entity
@Data
@Table(name="college_ordinary")
public class CollegeOrdinary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "序号")
    private Integer id;

    @Column(name = "`college_name`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "院校名称")
    private String collegeName;

    @Column(name = "`province`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "省份")
    private String province;

    @Column(name = "`city`",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "城市")
    private String city;

    public void copy(CollegeOrdinary source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
