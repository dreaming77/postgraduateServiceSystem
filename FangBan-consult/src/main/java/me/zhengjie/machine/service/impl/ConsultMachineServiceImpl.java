
package me.zhengjie.machine.service.impl;

import me.zhengjie.machine.domain.ConsultMachine;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.machine.repository.ConsultMachineRepository;
import me.zhengjie.machine.service.ConsultMachineService;
import me.zhengjie.machine.service.dto.ConsultMachineDto;
import me.zhengjie.machine.service.dto.ConsultMachineQueryCriteria;
import me.zhengjie.machine.service.mapstruct.ConsultMachineMapper;
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
public class ConsultMachineServiceImpl implements ConsultMachineService {

    private final ConsultMachineRepository consultMachineRepository;
    private final ConsultMachineMapper consultMachineMapper;

    @Override
    public Map<String,Object> queryAll(ConsultMachineQueryCriteria criteria, Pageable pageable){
        Page<ConsultMachine> page = consultMachineRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(consultMachineMapper::toDto));
    }

    @Override
    public List<ConsultMachineDto> queryAll(ConsultMachineQueryCriteria criteria){
        return consultMachineMapper.toDto(consultMachineRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ConsultMachineDto findById(Integer id) {
        ConsultMachine consultMachine = consultMachineRepository.findById(id).orElseGet(ConsultMachine::new);
        ValidationUtil.isNull(consultMachine.getId(),"ConsultMachine","id",id);
        return consultMachineMapper.toDto(consultMachine);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConsultMachineDto create(ConsultMachine resources) {
        return consultMachineMapper.toDto(consultMachineRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ConsultMachine resources) {
        ConsultMachine consultMachine = consultMachineRepository.findById(resources.getId()).orElseGet(ConsultMachine::new);
        ValidationUtil.isNull( consultMachine.getId(),"ConsultMachine","id",resources.getId());
        consultMachine.copy(resources);
        consultMachineRepository.save(consultMachine);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            consultMachineRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ConsultMachineDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ConsultMachineDto consultMachine : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("咨询类型", consultMachine.getCategories());
            map.put("用户信息", consultMachine.getUserInformation());
            map.put("咨询标题", consultMachine.getTitle());
            map.put("对应解答", consultMachine.getAnswer());
            map.put("已解决", consultMachine.getIssolve());
            map.put("解答日期", consultMachine.getDate());
            map.put("满意度", consultMachine.getSatisfaction());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}