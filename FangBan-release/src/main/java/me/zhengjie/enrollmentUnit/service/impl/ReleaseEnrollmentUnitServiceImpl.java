
package me.zhengjie.enrollmentUnit.service.impl;

import me.zhengjie.enrollmentUnit.domain.ReleaseEnrollmentUnit;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.enrollmentUnit.repository.ReleaseEnrollmentUnitRepository;
import me.zhengjie.enrollmentUnit.service.ReleaseEnrollmentUnitService;
import me.zhengjie.enrollmentUnit.service.dto.ReleaseEnrollmentUnitDto;
import me.zhengjie.enrollmentUnit.service.dto.ReleaseEnrollmentUnitQueryCriteria;
import me.zhengjie.enrollmentUnit.service.mapstruct.ReleaseEnrollmentUnitMapper;
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
* @date 2023-05-01
**/
@Service
@RequiredArgsConstructor
public class ReleaseEnrollmentUnitServiceImpl implements ReleaseEnrollmentUnitService {

    private final ReleaseEnrollmentUnitRepository releaseEnrollmentUnitRepository;
    private final ReleaseEnrollmentUnitMapper releaseEnrollmentUnitMapper;

    @Override
    public Map<String,Object> queryAll(ReleaseEnrollmentUnitQueryCriteria criteria, Pageable pageable){
        Page<ReleaseEnrollmentUnit> page = releaseEnrollmentUnitRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(releaseEnrollmentUnitMapper::toDto));
    }

    @Override
    public List<ReleaseEnrollmentUnitDto> queryAll(ReleaseEnrollmentUnitQueryCriteria criteria){
        return releaseEnrollmentUnitMapper.toDto(releaseEnrollmentUnitRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ReleaseEnrollmentUnitDto findById(Long id) {
        ReleaseEnrollmentUnit releaseEnrollmentUnit = releaseEnrollmentUnitRepository.findById(id).orElseGet(ReleaseEnrollmentUnit::new);
        ValidationUtil.isNull(releaseEnrollmentUnit.getId(),"ReleaseEnrollmentUnit","id",id);
        return releaseEnrollmentUnitMapper.toDto(releaseEnrollmentUnit);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReleaseEnrollmentUnitDto create(ReleaseEnrollmentUnit resources) {
        return releaseEnrollmentUnitMapper.toDto(releaseEnrollmentUnitRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ReleaseEnrollmentUnit resources) {
        ReleaseEnrollmentUnit releaseEnrollmentUnit = releaseEnrollmentUnitRepository.findById(resources.getId()).orElseGet(ReleaseEnrollmentUnit::new);
        ValidationUtil.isNull( releaseEnrollmentUnit.getId(),"ReleaseEnrollmentUnit","id",resources.getId());
        releaseEnrollmentUnit.copy(resources);
        releaseEnrollmentUnitRepository.save(releaseEnrollmentUnit);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            releaseEnrollmentUnitRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ReleaseEnrollmentUnitDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ReleaseEnrollmentUnitDto releaseEnrollmentUnit : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("学院名称", releaseEnrollmentUnit.getUnit());
            map.put("标题", releaseEnrollmentUnit.getTitle());
            map.put("链接地址", releaseEnrollmentUnit.getUrl());
            map.put("信息类型", releaseEnrollmentUnit.getType());
            map.put("发布日期", releaseEnrollmentUnit.getDate());
            map.put("浏览人数", releaseEnrollmentUnit.getBrowser());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}