
package me.zhengjie.feedback.service.impl;

import me.zhengjie.feedback.domain.ConsultFeedback;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.feedback.repository.ConsultFeedbackRepository;
import me.zhengjie.feedback.service.ConsultFeedbackService;
import me.zhengjie.feedback.service.dto.ConsultFeedbackDto;
import me.zhengjie.feedback.service.dto.ConsultFeedbackQueryCriteria;
import me.zhengjie.feedback.service.mapstruct.ConsultFeedbackMapper;
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
* @date 2023-04-27
**/
@Service
@RequiredArgsConstructor
public class ConsultFeedbackServiceImpl implements ConsultFeedbackService {

    private final ConsultFeedbackRepository consultFeedbackRepository;
    private final ConsultFeedbackMapper consultFeedbackMapper;

    @Override
    public Map<String,Object> queryAll(ConsultFeedbackQueryCriteria criteria, Pageable pageable){
        Page<ConsultFeedback> page = consultFeedbackRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(consultFeedbackMapper::toDto));
    }

    @Override
    public List<ConsultFeedbackDto> queryAll(ConsultFeedbackQueryCriteria criteria){
        return consultFeedbackMapper.toDto(consultFeedbackRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ConsultFeedbackDto findById(Integer id) {
        ConsultFeedback consultFeedback = consultFeedbackRepository.findById(id).orElseGet(ConsultFeedback::new);
        ValidationUtil.isNull(consultFeedback.getId(),"ConsultFeedback","id",id);
        return consultFeedbackMapper.toDto(consultFeedback);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConsultFeedbackDto create(ConsultFeedback resources) {
        return consultFeedbackMapper.toDto(consultFeedbackRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ConsultFeedback resources) {
        ConsultFeedback consultFeedback = consultFeedbackRepository.findById(resources.getId()).orElseGet(ConsultFeedback::new);
        ValidationUtil.isNull( consultFeedback.getId(),"ConsultFeedback","id",resources.getId());
        consultFeedback.copy(resources);
        consultFeedbackRepository.save(consultFeedback);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            consultFeedbackRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ConsultFeedbackDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ConsultFeedbackDto consultFeedback : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("用户名", consultFeedback.getUsername());
            map.put("反馈时间", consultFeedback.getSubmitDate());
            map.put("用户联系方式", consultFeedback.getContact());
            map.put("反馈内容", consultFeedback.getFeedbackContent());
            map.put("已处理", consultFeedback.getProcessed());
            map.put("处理客服", consultFeedback.getCustomer());
            map.put("性别", consultFeedback.getSex());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}