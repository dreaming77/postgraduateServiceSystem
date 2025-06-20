
package me.zhengjie.speciality_academic.service.dto;

import lombok.Data;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-17
**/
@Data
public class SpecialityAcademicQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String specialityName;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String code;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String category;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String orientation;
}