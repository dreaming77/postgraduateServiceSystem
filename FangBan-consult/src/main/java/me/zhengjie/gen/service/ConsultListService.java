
package me.zhengjie.gen.service;

import me.zhengjie.gen.domain.ConsultList;
import me.zhengjie.gen.service.dto.ConsultListDto;
import me.zhengjie.gen.service.dto.ConsultListQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://eladmin.vip
* @description 服务接口
* @author dreaming
* @date 2023-04-19
**/
public interface ConsultListService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ConsultListQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ConsultListDto>
    */
    List<ConsultListDto> queryAll(ConsultListQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ConsultListDto
     */
    ConsultListDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return ConsultListDto
    */
    ConsultListDto create(ConsultList resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ConsultList resources);

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
    void download(List<ConsultListDto> all, HttpServletResponse response) throws IOException;
}