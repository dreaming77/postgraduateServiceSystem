
package me.zhengjie.enrollmentUnit.service;

import me.zhengjie.enrollmentUnit.domain.ReleaseEnrollmentUnit;
import me.zhengjie.enrollmentUnit.service.dto.ReleaseEnrollmentUnitDto;
import me.zhengjie.enrollmentUnit.service.dto.ReleaseEnrollmentUnitQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://eladmin.vip
* @description 服务接口
* @author dreaming
* @date 2023-05-01
**/
public interface ReleaseEnrollmentUnitService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ReleaseEnrollmentUnitQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ReleaseEnrollmentUnitDto>
    */
    List<ReleaseEnrollmentUnitDto> queryAll(ReleaseEnrollmentUnitQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ReleaseEnrollmentUnitDto
     */
    ReleaseEnrollmentUnitDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return ReleaseEnrollmentUnitDto
    */
    ReleaseEnrollmentUnitDto create(ReleaseEnrollmentUnit resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ReleaseEnrollmentUnit resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<ReleaseEnrollmentUnitDto> all, HttpServletResponse response) throws IOException;
}