
package me.zhengjie.speciality_academic.service.impl;

import me.zhengjie.speciality_academic.domain.SpecialityAcademic;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.speciality_academic.repository.SpecialityAcademicRepository;
import me.zhengjie.speciality_academic.service.SpecialityAcademicService;
import me.zhengjie.speciality_academic.service.dto.SpecialityAcademicDto;
import me.zhengjie.speciality_academic.service.dto.SpecialityAcademicQueryCriteria;
import me.zhengjie.speciality_academic.service.mapstruct.SpecialityAcademicMapper;
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
public class SpecialityAcademicServiceImpl implements SpecialityAcademicService {

    private final SpecialityAcademicRepository specialityAcademicRepository;
    private final SpecialityAcademicMapper specialityAcademicMapper;

    @Override
    public Map<String,Object> queryAll(SpecialityAcademicQueryCriteria criteria, Pageable pageable){
        Page<SpecialityAcademic> page = specialityAcademicRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(specialityAcademicMapper::toDto));
    }

    @Override
    public List<SpecialityAcademicDto> queryAll(SpecialityAcademicQueryCriteria criteria){
        return specialityAcademicMapper.toDto(specialityAcademicRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public SpecialityAcademicDto findById(Integer id) {
        SpecialityAcademic specialityAcademic = specialityAcademicRepository.findById(id).orElseGet(SpecialityAcademic::new);
        ValidationUtil.isNull(specialityAcademic.getId(),"SpecialityAcademic","id",id);
        return specialityAcademicMapper.toDto(specialityAcademic);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SpecialityAcademicDto create(SpecialityAcademic resources) {
        return specialityAcademicMapper.toDto(specialityAcademicRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SpecialityAcademic resources) {
        SpecialityAcademic specialityAcademic = specialityAcademicRepository.findById(resources.getId()).orElseGet(SpecialityAcademic::new);
        ValidationUtil.isNull( specialityAcademic.getId(),"SpecialityAcademic","id",resources.getId());
        specialityAcademic.copy(resources);
        specialityAcademicRepository.save(specialityAcademic);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            specialityAcademicRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<SpecialityAcademicDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (SpecialityAcademicDto specialityAcademic : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("专业名称", specialityAcademic.getSpecialityName());
            map.put("专业代码", specialityAcademic.getCode());
            map.put("相关院校", specialityAcademic.getRelativeColleges());
            map.put("专业主页", specialityAcademic.getHomepage());
            map.put("类别", specialityAcademic.getCategory());
            map.put("方向", specialityAcademic.getOrientation());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}