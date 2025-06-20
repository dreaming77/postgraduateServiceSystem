
package me.zhengjie.policy.conversation.service;

import me.zhengjie.policy.conversation.domain.PolicyConversation;
import me.zhengjie.policy.conversation.service.dto.PolicyConversationDto;
import me.zhengjie.policy.conversation.service.dto.PolicyConversationQueryCriteria;
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
public interface PolicyConversationService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(PolicyConversationQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<PolicyConversationDto>
    */
    List<PolicyConversationDto> queryAll(PolicyConversationQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return PolicyConversationDto
     */
    PolicyConversationDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return PolicyConversationDto
    */
    PolicyConversationDto create(PolicyConversation resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(PolicyConversation resources);

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
    void download(List<PolicyConversationDto> all, HttpServletResponse response) throws IOException;
}