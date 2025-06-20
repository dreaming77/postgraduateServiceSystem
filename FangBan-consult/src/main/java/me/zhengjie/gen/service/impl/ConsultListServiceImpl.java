
package me.zhengjie.gen.service.impl;

import me.zhengjie.gen.domain.ConsultList;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.gen.repository.ConsultListRepository;
import me.zhengjie.gen.service.ConsultListService;
import me.zhengjie.gen.service.dto.ConsultListDto;
import me.zhengjie.gen.service.dto.ConsultListQueryCriteria;
import me.zhengjie.gen.service.mapstruct.ConsultListMapper;
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
* @date 2023-04-19
**/
@Service
@RequiredArgsConstructor
public class ConsultListServiceImpl implements ConsultListService {

    private final ConsultListRepository consultListRepository;
    private final ConsultListMapper consultListMapper;

    @Override
    public Map<String,Object> queryAll(ConsultListQueryCriteria criteria, Pageable pageable){
        Page<ConsultList> page = consultListRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(consultListMapper::toDto));
    }

    @Override
    public List<ConsultListDto> queryAll(ConsultListQueryCriteria criteria){
        return consultListMapper.toDto(consultListRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ConsultListDto findById(Integer id) {
        ConsultList consultList = consultListRepository.findById(id).orElseGet(ConsultList::new);
        ValidationUtil.isNull(consultList.getId(),"ConsultList","id",id);
        return consultListMapper.toDto(consultList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConsultListDto create(ConsultList resources) {
        return consultListMapper.toDto(consultListRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ConsultList resources) {
        ConsultList consultList = consultListRepository.findById(resources.getId()).orElseGet(ConsultList::new);
        ValidationUtil.isNull( consultList.getId(),"ConsultList","id",resources.getId());
        consultList.copy(resources);
        consultListRepository.save(consultList);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            consultListRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ConsultListDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ConsultListDto consultList : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("发布者信息", consultList.getUsername());
            map.put("添加时间", consultList.getAddtime());
            map.put("咨询标题", consultList.getTitle());
            map.put("咨询内容", consultList.getContent());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}