
package me.zhengjie.speciality_professional.service.impl;

import me.zhengjie.speciality_professional.domain.SpecialityProfessional;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.speciality_professional.repository.SpecialityProfessionalRepository;
import me.zhengjie.speciality_professional.service.SpecialityProfessionalService;
import me.zhengjie.speciality_professional.service.dto.SpecialityProfessionalDto;
import me.zhengjie.speciality_professional.service.dto.SpecialityProfessionalQueryCriteria;
import me.zhengjie.speciality_professional.service.mapstruct.SpecialityProfessionalMapper;
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
* @date 2023-05-17
**/
@Service
@RequiredArgsConstructor
public class SpecialityProfessionalServiceImpl implements SpecialityProfessionalService {

    private final SpecialityProfessionalRepository specialityProfessionalRepository;
    private final SpecialityProfessionalMapper specialityProfessionalMapper;

    @Override
    public Map<String,Object> queryAll(SpecialityProfessionalQueryCriteria criteria, Pageable pageable){
        Page<SpecialityProfessional> page = specialityProfessionalRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(specialityProfessionalMapper::toDto));
    }

    @Override
    public List<SpecialityProfessionalDto> queryAll(SpecialityProfessionalQueryCriteria criteria){
        return specialityProfessionalMapper.toDto(specialityProfessionalRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public SpecialityProfessionalDto findById(Integer id) {
        SpecialityProfessional specialityProfessional = specialityProfessionalRepository.findById(id).orElseGet(SpecialityProfessional::new);
        ValidationUtil.isNull(specialityProfessional.getId(),"SpecialityProfessional","id",id);
        return specialityProfessionalMapper.toDto(specialityProfessional);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SpecialityProfessionalDto create(SpecialityProfessional resources) {
        return specialityProfessionalMapper.toDto(specialityProfessionalRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SpecialityProfessional resources) {
        SpecialityProfessional specialityProfessional = specialityProfessionalRepository.findById(resources.getId()).orElseGet(SpecialityProfessional::new);
        ValidationUtil.isNull( specialityProfessional.getId(),"SpecialityProfessional","id",resources.getId());
        specialityProfessional.copy(resources);
        specialityProfessionalRepository.save(specialityProfessional);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            specialityProfessionalRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<SpecialityProfessionalDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (SpecialityProfessionalDto specialityProfessional : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("专业名称", specialityProfessional.getSpecialityName());
            map.put("专业代码", specialityProfessional.getCode());
            map.put("相关院校", specialityProfessional.getRelativeColleges());
            map.put("专业主页", specialityProfessional.getHomepage());
            map.put("类别", specialityProfessional.getCategory());
            map.put("方向", specialityProfessional.getOrientation());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}