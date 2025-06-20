
package me.zhengjie.policy.domestic.service;

import me.zhengjie.policy.domestic.domain.PolicyDomestic;
import me.zhengjie.policy.domestic.service.dto.PolicyDomesticDto;
import me.zhengjie.policy.domestic.service.dto.PolicyDomesticQueryCriteria;
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
public interface PolicyDomesticService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(PolicyDomesticQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<PolicyDomesticDto>
    */
    List<PolicyDomesticDto> queryAll(PolicyDomesticQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return PolicyDomesticDto
     */
    PolicyDomesticDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return PolicyDomesticDto
    */
    PolicyDomesticDto create(PolicyDomestic resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(PolicyDomestic resources);

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
    void download(List<PolicyDomesticDto> all, HttpServletResponse response) throws IOException;
}