
package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.service.dto.UserDto;
import java.util.List;


public interface DataService {

    /**
     * 获取数据权限
     * @param user /
     * @return /
     */
    List<Long> getDeptIds(UserDto user);
}
