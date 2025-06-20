
package me.zhengjie.college_985.service.impl;

import me.zhengjie.college_985.domain.College985;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.college_985.repository.College985Repository;
import me.zhengjie.college_985.service.College985Service;
import me.zhengjie.college_985.service.dto.College985Dto;
import me.zhengjie.college_985.service.dto.College985QueryCriteria;
import me.zhengjie.college_985.service.mapstruct.College985Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
* @website https://eladmin.vip
* @description 服务实现
* @author dreaming
* @date 2023-05-16
**/
@Service
@RequiredArgsConstructor
public class College985ServiceImpl implements College985Service {

    private final College985Repository college985Repository;
    private final College985Mapper college985Mapper;

    @Override
    public Map<String,Object> queryAll(College985QueryCriteria criteria, Pageable pageable){
        Page<College985> page = college985Repository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(college985Mapper::toDto));
    }

    @Override
    public List<College985Dto> queryAll(College985QueryCriteria criteria){
        return college985Mapper.toDto(college985Repository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public College985Dto findById(Integer id) {
        College985 college985 = college985Repository.findById(id).orElseGet(College985::new);
        ValidationUtil.isNull(college985.getId(),"College985","id",id);
        return college985Mapper.toDto(college985);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public College985Dto create(College985 resources) {
        return college985Mapper.toDto(college985Repository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(College985 resources) {
        College985 college985 = college985Repository.findById(resources.getId()).orElseGet(College985::new);
        ValidationUtil.isNull( college985.getId(),"College985","id",resources.getId());
        college985.copy(resources);
        college985Repository.save(college985);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            college985Repository.deleteById(id);
        }
    }

    @Override
    public void download(List<College985Dto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (College985Dto college985 : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("院校名称", college985.getCollegeName());
            map.put("院校排名", college985.getRange());
            map.put("网站地址", college985.getUrl());
            map.put("省份", college985.getProvince());
            map.put("城市", college985.getCity());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}