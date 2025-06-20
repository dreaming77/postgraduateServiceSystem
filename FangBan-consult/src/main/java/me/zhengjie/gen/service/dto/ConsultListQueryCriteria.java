
package me.zhengjie.gen.service.dto;

import lombok.Data;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-19
**/
@Data
public class ConsultListQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String title;
}