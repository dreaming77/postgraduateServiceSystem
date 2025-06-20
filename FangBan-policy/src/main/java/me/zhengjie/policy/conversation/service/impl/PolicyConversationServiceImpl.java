
package me.zhengjie.policy.conversation.service.impl;

import me.zhengjie.policy.conversation.domain.PolicyConversation;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.policy.conversation.repository.PolicyConversationRepository;
import me.zhengjie.policy.conversation.service.PolicyConversationService;
import me.zhengjie.policy.conversation.service.dto.PolicyConversationDto;
import me.zhengjie.policy.conversation.service.dto.PolicyConversationQueryCriteria;
import me.zhengjie.policy.conversation.service.mapstruct.PolicyConversationMapper;
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
public class PolicyConversationServiceImpl implements PolicyConversationService {

    private final PolicyConversationRepository policyConversationRepository;
    private final PolicyConversationMapper policyConversationMapper;

    @Override
    public Map<String,Object> queryAll(PolicyConversationQueryCriteria criteria, Pageable pageable){
        Page<PolicyConversation> page = policyConversationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(policyConversationMapper::toDto));
    }

    @Override
    public List<PolicyConversationDto> queryAll(PolicyConversationQueryCriteria criteria){
        return policyConversationMapper.toDto(policyConversationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public PolicyConversationDto findById(Integer id) {
        PolicyConversation policyConversation = policyConversationRepository.findById(id).orElseGet(PolicyConversation::new);
        ValidationUtil.isNull(policyConversation.getId(),"PolicyConversation","id",id);
        return policyConversationMapper.toDto(policyConversation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyConversationDto create(PolicyConversation resources) {
        return policyConversationMapper.toDto(policyConversationRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PolicyConversation resources) {
        PolicyConversation policyConversation = policyConversationRepository.findById(resources.getId()).orElseGet(PolicyConversation::new);
        ValidationUtil.isNull( policyConversation.getId(),"PolicyConversation","id",resources.getId());
        policyConversation.copy(resources);
        policyConversationRepository.save(policyConversation);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            policyConversationRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<PolicyConversationDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (PolicyConversationDto policyConversation : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("标题", policyConversation.getTitle());
            map.put("信息来源", policyConversation.getOriginResource());
            map.put("发布日期", policyConversation.getDate());
            map.put("访谈内容", policyConversation.getContent());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}