package me.zhengjie.machine.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-04-27
**/
@Data
public class ConsultMachineDto implements Serializable {

    /** 序号 */
    private Integer id;

    /** 咨询类型 */
    private String categories;

    /** 用户信息 */
    private String userInformation;

    /** 咨询标题 */
    private String title;

    /** 对应解答 */
    private String answer;

    /** 已解决 */
    private String issolve;

    /** 解答日期 */
    private Timestamp date;

    /** 满意度 */
    private String satisfaction;
}