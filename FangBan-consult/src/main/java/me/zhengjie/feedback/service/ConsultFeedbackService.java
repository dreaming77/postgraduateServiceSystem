
package me.zhengjie.feedback.service;

import me.zhengjie.feedback.domain.ConsultFeedback;
import me.zhengjie.feedback.service.dto.ConsultFeedbackDto;
import me.zhengjie.feedback.service.dto.ConsultFeedbackQueryCriteria;
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
public interface ConsultFeedbackService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ConsultFeedbackQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ConsultFeedbackDto>
    */
    List<ConsultFeedbackDto> queryAll(ConsultFeedbackQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ConsultFeedbackDto
     */
    ConsultFeedbackDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return ConsultFeedbackDto
    */
    ConsultFeedbackDto create(ConsultFeedback resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ConsultFeedback resources);

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
    void download(List<ConsultFeedbackDto> all, HttpServletResponse response) throws IOException;
}