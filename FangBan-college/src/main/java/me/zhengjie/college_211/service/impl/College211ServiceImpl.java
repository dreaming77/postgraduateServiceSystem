
package me.zhengjie.college_211.service.impl;

import me.zhengjie.college_211.domain.College211;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.college_211.repository.College211Repository;
import me.zhengjie.college_211.service.College211Service;
import me.zhengjie.college_211.service.dto.College211Dto;
import me.zhengjie.college_211.service.dto.College211QueryCriteria;
import me.zhengjie.college_211.service.mapstruct.College211Mapper;
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
public class College211ServiceImpl implements College211Service {

    private final College211Repository college211Repository;
    private final College211Mapper college211Mapper;

    @Override
    public Map<String,Object> queryAll(College211QueryCriteria criteria, Pageable pageable){
        Page<College211> page = college211Repository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(college211Mapper::toDto));
    }

    @Override
    public List<College211Dto> queryAll(College211QueryCriteria criteria){
        return college211Mapper.toDto(college211Repository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public College211Dto findById(Integer id) {
        College211 college211 = college211Repository.findById(id).orElseGet(College211::new);
        ValidationUtil.isNull(college211.getId(),"College211","id",id);
        return college211Mapper.toDto(college211);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public College211Dto create(College211 resources) {
        return college211Mapper.toDto(college211Repository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(College211 resources) {
        College211 college211 = college211Repository.findById(resources.getId()).orElseGet(College211::new);
        ValidationUtil.isNull( college211.getId(),"College211","id",resources.getId());
        college211.copy(resources);
        college211Repository.save(college211);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            college211Repository.deleteById(id);
        }
    }

    @Override
    public void download(List<College211Dto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (College211Dto college211 : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("院校名称", college211.getCollegeName());
            map.put("院校排名", college211.getRange());
            map.put("省份", college211.getProvince());
            map.put("城市", college211.getCity());
            map.put("网站地址", college211.getUrl());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}