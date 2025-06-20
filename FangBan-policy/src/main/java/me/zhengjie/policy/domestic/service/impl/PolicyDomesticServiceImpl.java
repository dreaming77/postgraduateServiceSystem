
package me.zhengjie.policy.domestic.service.impl;

import me.zhengjie.policy.domestic.domain.PolicyDomestic;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.policy.domestic.repository.PolicyDomesticRepository;
import me.zhengjie.policy.domestic.service.PolicyDomesticService;
import me.zhengjie.policy.domestic.service.dto.PolicyDomesticDto;
import me.zhengjie.policy.domestic.service.dto.PolicyDomesticQueryCriteria;
import me.zhengjie.policy.domestic.service.mapstruct.PolicyDomesticMapper;
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
public class PolicyDomesticServiceImpl implements PolicyDomesticService {

    private final PolicyDomesticRepository policyDomesticRepository;
    private final PolicyDomesticMapper policyDomesticMapper;

    @Override
    public Map<String,Object> queryAll(PolicyDomesticQueryCriteria criteria, Pageable pageable){
        Page<PolicyDomestic> page = policyDomesticRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(policyDomesticMapper::toDto));
    }

    @Override
    public List<PolicyDomesticDto> queryAll(PolicyDomesticQueryCriteria criteria){
        return policyDomesticMapper.toDto(policyDomesticRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public PolicyDomesticDto findById(Integer id) {
        PolicyDomestic policyDomestic = policyDomesticRepository.findById(id).orElseGet(PolicyDomestic::new);
        ValidationUtil.isNull(policyDomestic.getId(),"PolicyDomestic","id",id);
        return policyDomesticMapper.toDto(policyDomestic);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyDomesticDto create(PolicyDomestic resources) {
        return policyDomesticMapper.toDto(policyDomesticRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PolicyDomestic resources) {
        PolicyDomestic policyDomestic = policyDomesticRepository.findById(resources.getId()).orElseGet(PolicyDomestic::new);
        ValidationUtil.isNull( policyDomestic.getId(),"PolicyDomestic","id",resources.getId());
        policyDomestic.copy(resources);
        policyDomesticRepository.save(policyDomestic);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            policyDomesticRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<PolicyDomesticDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (PolicyDomesticDto policyDomestic : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("标题", policyDomestic.getTitle());
            map.put("信息来源", policyDomestic.getOriginResource());
            map.put("网站地址", policyDomestic.getUrl());
            map.put("发布日期", policyDomestic.getPublishDate());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}