
package me.zhengjie.feedback.service.dto;

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
public class ConsultFeedbackQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String username;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp submitDate;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String contact;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String customer;
}