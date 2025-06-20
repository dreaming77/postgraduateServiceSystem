
package me.zhengjie.college_211.domain;

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
@Table(name="college_211")
public class College211 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "序号")
    private Integer id;

    @Column(name = "`college_name`")
    @ApiModelProperty(value = "院校名称")
    private String collegeName;

    @Column(name = "`range`")
    @ApiModelProperty(value = "院校排名")
    private Integer range;

    @Column(name = "`province`")
    @ApiModelProperty(value = "省份")
    private String province;

    @Column(name = "`city`")
    @ApiModelProperty(value = "城市")
    private String city;

    @Column(name = "`url`")
    @ApiModelProperty(value = "网站地址")
    private String url;

    public void copy(College211 source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
