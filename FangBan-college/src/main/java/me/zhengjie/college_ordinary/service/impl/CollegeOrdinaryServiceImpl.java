
package me.zhengjie.college_ordinary.service.impl;

import me.zhengjie.college_ordinary.domain.CollegeOrdinary;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.college_ordinary.repository.CollegeOrdinaryRepository;
import me.zhengjie.college_ordinary.service.CollegeOrdinaryService;
import me.zhengjie.college_ordinary.service.dto.CollegeOrdinaryDto;
import me.zhengjie.college_ordinary.service.dto.CollegeOrdinaryQueryCriteria;
import me.zhengjie.college_ordinary.service.mapstruct.CollegeOrdinaryMapper;
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
public class CollegeOrdinaryServiceImpl implements CollegeOrdinaryService {

    private final CollegeOrdinaryRepository collegeOrdinaryRepository;
    private final CollegeOrdinaryMapper collegeOrdinaryMapper;

    @Override
    public Map<String,Object> queryAll(CollegeOrdinaryQueryCriteria criteria, Pageable pageable){
        Page<CollegeOrdinary> page = collegeOrdinaryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(collegeOrdinaryMapper::toDto));
    }

    @Override
    public List<CollegeOrdinaryDto> queryAll(CollegeOrdinaryQueryCriteria criteria){
        return collegeOrdinaryMapper.toDto(collegeOrdinaryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public CollegeOrdinaryDto findById(Integer id) {
        CollegeOrdinary collegeOrdinary = collegeOrdinaryRepository.findById(id).orElseGet(CollegeOrdinary::new);
        ValidationUtil.isNull(collegeOrdinary.getId(),"CollegeOrdinary","id",id);
        return collegeOrdinaryMapper.toDto(collegeOrdinary);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CollegeOrdinaryDto create(CollegeOrdinary resources) {
        return collegeOrdinaryMapper.toDto(collegeOrdinaryRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CollegeOrdinary resources) {
        CollegeOrdinary collegeOrdinary = collegeOrdinaryRepository.findById(resources.getId()).orElseGet(CollegeOrdinary::new);
        ValidationUtil.isNull( collegeOrdinary.getId(),"CollegeOrdinary","id",resources.getId());
        collegeOrdinary.copy(resources);
        collegeOrdinaryRepository.save(collegeOrdinary);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            collegeOrdinaryRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<CollegeOrdinaryDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (CollegeOrdinaryDto collegeOrdinary : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("院校名称", collegeOrdinary.getCollegeName());
            map.put("省份", collegeOrdinary.getProvince());
            map.put("城市", collegeOrdinary.getCity());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}