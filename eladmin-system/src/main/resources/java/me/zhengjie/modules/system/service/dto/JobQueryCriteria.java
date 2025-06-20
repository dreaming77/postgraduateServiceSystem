
package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.zhengjie.annotation.Query;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class JobQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query
    private Boolean enabled;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}