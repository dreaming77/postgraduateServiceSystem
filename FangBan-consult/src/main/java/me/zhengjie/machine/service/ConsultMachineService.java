
package me.zhengjie.machine.service;

import me.zhengjie.machine.domain.ConsultMachine;
import me.zhengjie.machine.service.dto.ConsultMachineDto;
import me.zhengjie.machine.service.dto.ConsultMachineQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://eladmin.vip
* @description 服务接口
* @author dreaming
* @date 2023-04-27
**/
public interface ConsultMachineService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ConsultMachineQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ConsultMachineDto>
    */
    List<ConsultMachineDto> queryAll(ConsultMachineQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ConsultMachineDto
     */
    ConsultMachineDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return ConsultMachineDto
    */
    ConsultMachineDto create(ConsultMachine resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ConsultMachine resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Integer[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<ConsultMachineDto> all, HttpServletResponse response) throws IOException;
}