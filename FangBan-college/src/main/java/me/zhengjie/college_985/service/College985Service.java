
package me.zhengjie.college_985.service;

import me.zhengjie.college_985.domain.College985;
import me.zhengjie.college_985.service.dto.College985Dto;
import me.zhengjie.college_985.service.dto.College985QueryCriteria;
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
public interface College985Service {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(College985QueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<College985Dto>
    */
    List<College985Dto> queryAll(College985QueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return College985Dto
     */
    College985Dto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return College985Dto
    */
    College985Dto create(College985 resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(College985 resources);

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
    void download(List<College985Dto> all, HttpServletResponse response) throws IOException;
}