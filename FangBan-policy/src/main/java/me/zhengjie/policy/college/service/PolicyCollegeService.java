
package me.zhengjie.policy.college.service;

import me.zhengjie.policy.college.domain.PolicyCollege;
import me.zhengjie.policy.college.service.dto.PolicyCollegeDto;
import me.zhengjie.policy.college.service.dto.PolicyCollegeQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://eladmin.vip
* @description 服务接口
* @author dreaming
* @date 2023-05-29
**/
public interface PolicyCollegeService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(PolicyCollegeQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<PolicyCollegeDto>
    */
    List<PolicyCollegeDto> queryAll(PolicyCollegeQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return PolicyCollegeDto
     */
    PolicyCollegeDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return PolicyCollegeDto
    */
    PolicyCollegeDto create(PolicyCollege resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(PolicyCollege resources);

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
    void download(List<PolicyCollegeDto> all, HttpServletResponse response) throws IOException;
}