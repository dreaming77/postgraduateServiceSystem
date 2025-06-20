
package me.zhengjie.college_ordinary.service;

import me.zhengjie.college_ordinary.domain.CollegeOrdinary;
import me.zhengjie.college_ordinary.service.dto.CollegeOrdinaryDto;
import me.zhengjie.college_ordinary.service.dto.CollegeOrdinaryQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://eladmin.vip
* @description 服务接口
* @author dreaming
* @date 2023-05-16
**/
public interface CollegeOrdinaryService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(CollegeOrdinaryQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<CollegeOrdinaryDto>
    */
    List<CollegeOrdinaryDto> queryAll(CollegeOrdinaryQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return CollegeOrdinaryDto
     */
    CollegeOrdinaryDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return CollegeOrdinaryDto
    */
    CollegeOrdinaryDto create(CollegeOrdinary resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(CollegeOrdinary resources);

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
    void download(List<CollegeOrdinaryDto> all, HttpServletResponse response) throws IOException;
}