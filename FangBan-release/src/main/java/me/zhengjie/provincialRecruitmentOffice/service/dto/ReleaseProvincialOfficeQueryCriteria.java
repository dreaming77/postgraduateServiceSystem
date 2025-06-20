
package me.zhengjie.provincialRecruitmentOffice.service.dto;

import lombok.Data;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-01
**/
@Data
public class ReleaseProvincialOfficeQueryCriteria{

    /** 精确 */
    @Query
    private String province;

    /** 精确 */
    @Query
    private String categories;
}