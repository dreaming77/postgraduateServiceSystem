package me.zhengjie.recruitResume.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://eladmin.vip
* @description /
* @author dreaming
* @date 2023-05-02
**/
@Data
public class ReleaseRecruitResumeDto implements Serializable {

    /** 序号 */
    private Integer id;

    /** 院校名称 */
    private String college;

    /** 招生简章 */
    private String resumeTitle;

    /** url地址 */
    private String url;

    /** 发布时间 */
    private Timestamp resumePublishDate;

    /** 联系单位电话 */
    private String contactPhoneNumber;

    /** 浏览次数 */
    private Integer broswer;
}