
package me.zhengjie.provincialRecruitmentOffice.service.impl;

import me.zhengjie.provincialRecruitmentOffice.domain.ReleaseProvincialOffice;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.provincialRecruitmentOffice.repository.ReleaseProvincialOfficeRepository;
import me.zhengjie.provincialRecruitmentOffice.service.ReleaseProvincialOfficeService;
import me.zhengjie.provincialRecruitmentOffice.service.dto.ReleaseProvincialOfficeDto;
import me.zhengjie.provincialRecruitmentOffice.service.dto.ReleaseProvincialOfficeQueryCriteria;
import me.zhengjie.provincialRecruitmentOffice.service.mapstruct.ReleaseProvincialOfficeMapper;
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
public class ReleaseProvincialOfficeServiceImpl implements ReleaseProvincialOfficeService {

    private final ReleaseProvincialOfficeRepository releaseProvincialOfficeRepository;
    private final ReleaseProvincialOfficeMapper releaseProvincialOfficeMapper;

    @Override
    public Map<String,Object> queryAll(ReleaseProvincialOfficeQueryCriteria criteria, Pageable pageable){
        Page<ReleaseProvincialOffice> page = releaseProvincialOfficeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(releaseProvincialOfficeMapper::toDto));
    }

    @Override
    public List<ReleaseProvincialOfficeDto> queryAll(ReleaseProvincialOfficeQueryCriteria criteria){
        return releaseProvincialOfficeMapper.toDto(releaseProvincialOfficeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ReleaseProvincialOfficeDto findById(Integer id) {
        ReleaseProvincialOffice releaseProvincialOffice = releaseProvincialOfficeRepository.findById(id).orElseGet(ReleaseProvincialOffice::new);
        ValidationUtil.isNull(releaseProvincialOffice.getId(),"ReleaseProvincialOffice","id",id);
        return releaseProvincialOfficeMapper.toDto(releaseProvincialOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReleaseProvincialOfficeDto create(ReleaseProvincialOffice resources) {
        return releaseProvincialOfficeMapper.toDto(releaseProvincialOfficeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ReleaseProvincialOffice resources) {
        ReleaseProvincialOffice releaseProvincialOffice = releaseProvincialOfficeRepository.findById(resources.getId()).orElseGet(ReleaseProvincialOffice::new);
        ValidationUtil.isNull( releaseProvincialOffice.getId(),"ReleaseProvincialOffice","id",resources.getId());
        releaseProvincialOffice.copy(resources);
        releaseProvincialOfficeRepository.save(releaseProvincialOffice);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            releaseProvincialOfficeRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ReleaseProvincialOfficeDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ReleaseProvincialOfficeDto releaseProvincialOffice : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("发布省份", releaseProvincialOffice.getProvince());
            map.put("标题", releaseProvincialOffice.getTitle());
            map.put("信息类型", releaseProvincialOffice.getCategories());
            map.put("url地址", releaseProvincialOffice.getUrl());
            map.put("发布日期", releaseProvincialOffice.getPublishDate());
            map.put("咨询电话", releaseProvincialOffice.getPhoneNumber());
            map.put("浏览次数", releaseProvincialOffice.getViews());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}