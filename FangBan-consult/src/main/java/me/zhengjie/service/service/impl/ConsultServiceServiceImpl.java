
package me.zhengjie.service.service.impl;

import me.zhengjie.service.domain.ConsultService;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.service.repository.ConsultServiceRepository;
import me.zhengjie.service.service.ConsultServiceService;
import me.zhengjie.service.service.dto.ConsultServiceDto;
import me.zhengjie.service.service.dto.ConsultServiceQueryCriteria;
import me.zhengjie.service.service.mapstruct.ConsultServiceMapper;
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
public class ConsultServiceServiceImpl implements ConsultServiceService {

    private final ConsultServiceRepository consultServiceRepository;
    private final ConsultServiceMapper consultServiceMapper;

    @Override
    public Map<String,Object> queryAll(ConsultServiceQueryCriteria criteria, Pageable pageable){
        Page<ConsultService> page = consultServiceRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(consultServiceMapper::toDto));
    }

    @Override
    public List<ConsultServiceDto> queryAll(ConsultServiceQueryCriteria criteria){
        return consultServiceMapper.toDto(consultServiceRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ConsultServiceDto findById(Integer manualId) {
        ConsultService consultService = consultServiceRepository.findById(manualId).orElseGet(ConsultService::new);
        ValidationUtil.isNull(consultService.getManualId(),"ConsultService","manualId",manualId);
        return consultServiceMapper.toDto(consultService);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConsultServiceDto create(ConsultService resources) {
        return consultServiceMapper.toDto(consultServiceRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ConsultService resources) {
        ConsultService consultService = consultServiceRepository.findById(resources.getManualId()).orElseGet(ConsultService::new);
        ValidationUtil.isNull( consultService.getManualId(),"ConsultService","id",resources.getManualId());
        consultService.copy(resources);
        consultServiceRepository.save(consultService);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer manualId : ids) {
            consultServiceRepository.deleteById(manualId);
        }
    }

    @Override
    public void download(List<ConsultServiceDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ConsultServiceDto consultService : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("客服", consultService.getServiser());
            map.put("时长", consultService.getTimeLong());
            map.put("咨询日期", consultService.getServiceDate());
            map.put("服务满意程度", consultService.getSatisfaction());
            map.put("咨询内容", consultService.getContent());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}