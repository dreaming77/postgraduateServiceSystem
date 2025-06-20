
package me.zhengjie.college_985.service.dto;

import lombok.Data;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-16
**/
@Data
public class College985QueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String collegeName;
}