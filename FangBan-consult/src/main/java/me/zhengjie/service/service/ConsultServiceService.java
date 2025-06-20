
package me.zhengjie.service.service;

import me.zhengjie.service.domain.ConsultService;
import me.zhengjie.service.service.dto.ConsultServiceDto;
import me.zhengjie.service.service.dto.ConsultServiceQueryCriteria;
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
public interface ConsultServiceService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ConsultServiceQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ConsultServiceDto>
    */
    List<ConsultServiceDto> queryAll(ConsultServiceQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param manualId ID
     * @return ConsultServiceDto
     */
    ConsultServiceDto findById(Integer manualId);

    /**
    * 创建
    * @param resources /
    * @return ConsultServiceDto
    */
    ConsultServiceDto create(ConsultService resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ConsultService resources);

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
    void download(List<ConsultServiceDto> all, HttpServletResponse response) throws IOException;
}