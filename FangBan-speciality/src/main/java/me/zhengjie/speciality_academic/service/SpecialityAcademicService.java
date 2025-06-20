
package me.zhengjie.speciality_academic.service;

import me.zhengjie.speciality_academic.domain.SpecialityAcademic;
import me.zhengjie.speciality_academic.service.dto.SpecialityAcademicDto;
import me.zhengjie.speciality_academic.service.dto.SpecialityAcademicQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://eladmin.vip
* @description 服务接口
* @author dreaming
* @date 2023-05-17
**/
public interface SpecialityAcademicService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(SpecialityAcademicQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<SpecialityAcademicDto>
    */
    List<SpecialityAcademicDto> queryAll(SpecialityAcademicQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return SpecialityAcademicDto
     */
    SpecialityAcademicDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return SpecialityAcademicDto
    */
    SpecialityAcademicDto create(SpecialityAcademic resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(SpecialityAcademic resources);

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
    void download(List<SpecialityAcademicDto> all, HttpServletResponse response) throws IOException;
}