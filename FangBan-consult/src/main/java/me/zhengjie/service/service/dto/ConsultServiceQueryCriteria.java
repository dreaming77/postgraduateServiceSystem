
package me.zhengjie.service.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-27
**/
@Data
public class ConsultServiceQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private Integer manualId;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String serviser;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp serviceDate;
}