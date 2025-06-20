
package me.zhengjie.policy.college.service.impl;

import me.zhengjie.policy.college.domain.PolicyCollege;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.policy.college.repository.PolicyCollegeRepository;
import me.zhengjie.policy.college.service.PolicyCollegeService;
import me.zhengjie.policy.college.service.dto.PolicyCollegeDto;
import me.zhengjie.policy.college.service.dto.PolicyCollegeQueryCriteria;
import me.zhengjie.policy.college.service.mapstruct.PolicyCollegeMapper;
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
* @date 2023-05-29
**/
@Service
@RequiredArgsConstructor
public class PolicyCollegeServiceImpl implements PolicyCollegeService {

    private final PolicyCollegeRepository policyCollegeRepository;
    private final PolicyCollegeMapper policyCollegeMapper;

    @Override
    public Map<String,Object> queryAll(PolicyCollegeQueryCriteria criteria, Pageable pageable){
        Page<PolicyCollege> page = policyCollegeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(policyCollegeMapper::toDto));
    }

    @Override
    public List<PolicyCollegeDto> queryAll(PolicyCollegeQueryCriteria criteria){
        return policyCollegeMapper.toDto(policyCollegeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public PolicyCollegeDto findById(Integer id) {
        PolicyCollege policyCollege = policyCollegeRepository.findById(id).orElseGet(PolicyCollege::new);
        ValidationUtil.isNull(policyCollege.getId(),"PolicyCollege","id",id);
        return policyCollegeMapper.toDto(policyCollege);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyCollegeDto create(PolicyCollege resources) {
        return policyCollegeMapper.toDto(policyCollegeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PolicyCollege resources) {
        PolicyCollege policyCollege = policyCollegeRepository.findById(resources.getId()).orElseGet(PolicyCollege::new);
        ValidationUtil.isNull( policyCollege.getId(),"PolicyCollege","id",resources.getId());
        policyCollege.copy(resources);
        policyCollegeRepository.save(policyCollege);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            policyCollegeRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<PolicyCollegeDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (PolicyCollegeDto policyCollege : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("标题", policyCollege.getTitle());
            map.put("信息来源", policyCollege.getOriginResource());
            map.put("访问地址", policyCollege.getUrl());
            map.put("发布日期1", policyCollege.getPublishDate());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}