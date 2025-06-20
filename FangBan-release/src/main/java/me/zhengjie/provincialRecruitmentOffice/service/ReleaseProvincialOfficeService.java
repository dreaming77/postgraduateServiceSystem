
package me.zhengjie.provincialRecruitmentOffice.service;

import me.zhengjie.provincialRecruitmentOffice.domain.ReleaseProvincialOffice;
import me.zhengjie.provincialRecruitmentOffice.service.dto.ReleaseProvincialOfficeDto;
import me.zhengjie.provincialRecruitmentOffice.service.dto.ReleaseProvincialOfficeQueryCriteria;
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
public interface ReleaseProvincialOfficeService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ReleaseProvincialOfficeQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ReleaseProvincialOfficeDto>
    */
    List<ReleaseProvincialOfficeDto> queryAll(ReleaseProvincialOfficeQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ReleaseProvincialOfficeDto
     */
    ReleaseProvincialOfficeDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return ReleaseProvincialOfficeDto
    */
    ReleaseProvincialOfficeDto create(ReleaseProvincialOffice resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ReleaseProvincialOffice resources);

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
    void download(List<ReleaseProvincialOfficeDto> all, HttpServletResponse response) throws IOException;
}