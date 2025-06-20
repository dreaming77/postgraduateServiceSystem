
package me.zhengjie.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;
import java.sql.Timestamp;
import java.util.List;


@Data
public class LogQueryCriteria {

    @Query(blurry = "username,description,address,requestIp,method,params")
    private String blurry;

    @Query
    private String username;

    @Query
    private String logType;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
