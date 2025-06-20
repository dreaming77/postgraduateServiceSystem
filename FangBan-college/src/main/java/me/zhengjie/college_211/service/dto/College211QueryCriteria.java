
package me.zhengjie.college_211.service.dto;

import lombok.Data;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-16
**/
@Data
public class College211QueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String collegeName;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String province;
}