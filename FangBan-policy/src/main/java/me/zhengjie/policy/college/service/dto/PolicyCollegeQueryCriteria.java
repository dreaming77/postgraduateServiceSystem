
package me.zhengjie.policy.college.service.dto;

import lombok.Data;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-29
**/
@Data
public class PolicyCollegeQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String title;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String originResource;
}