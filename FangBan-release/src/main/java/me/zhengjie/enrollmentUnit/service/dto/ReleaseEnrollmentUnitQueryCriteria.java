
package me.zhengjie.enrollmentUnit.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-01
**/
@Data
public class ReleaseEnrollmentUnitQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String unit;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp date;
}