
package me.zhengjie.recruitResume.service.impl;

import me.zhengjie.recruitResume.domain.ReleaseRecruitResume;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.recruitResume.repository.ReleaseRecruitResumeRepository;
import me.zhengjie.recruitResume.service.ReleaseRecruitResumeService;
import me.zhengjie.recruitResume.service.dto.ReleaseRecruitResumeDto;
import me.zhengjie.recruitResume.service.dto.ReleaseRecruitResumeQueryCriteria;
import me.zhengjie.recruitResume.service.mapstruct.ReleaseRecruitResumeMapper;
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
* @date 2023-05-02
**/
@Service
@RequiredArgsConstructor
public class ReleaseRecruitResumeServiceImpl implements ReleaseRecruitResumeService {

    private final ReleaseRecruitResumeRepository releaseRecruitResumeRepository;
    private final ReleaseRecruitResumeMapper releaseRecruitResumeMapper;

    @Override
    public Map<String,Object> queryAll(ReleaseRecruitResumeQueryCriteria criteria, Pageable pageable){
        Page<ReleaseRecruitResume> page = releaseRecruitResumeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(releaseRecruitResumeMapper::toDto));
    }

    @Override
    public List<ReleaseRecruitResumeDto> queryAll(ReleaseRecruitResumeQueryCriteria criteria){
        return releaseRecruitResumeMapper.toDto(releaseRecruitResumeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ReleaseRecruitResumeDto findById(Integer id) {
        ReleaseRecruitResume releaseRecruitResume = releaseRecruitResumeRepository.findById(id).orElseGet(ReleaseRecruitResume::new);
        ValidationUtil.isNull(releaseRecruitResume.getId(),"ReleaseRecruitResume","id",id);
        return releaseRecruitResumeMapper.toDto(releaseRecruitResume);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReleaseRecruitResumeDto create(ReleaseRecruitResume resources) {
        return releaseRecruitResumeMapper.toDto(releaseRecruitResumeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ReleaseRecruitResume resources) {
        ReleaseRecruitResume releaseRecruitResume = releaseRecruitResumeRepository.findById(resources.getId()).orElseGet(ReleaseRecruitResume::new);
        ValidationUtil.isNull( releaseRecruitResume.getId(),"ReleaseRecruitResume","id",resources.getId());
        releaseRecruitResume.copy(resources);
        releaseRecruitResumeRepository.save(releaseRecruitResume);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            releaseRecruitResumeRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ReleaseRecruitResumeDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ReleaseRecruitResumeDto releaseRecruitResume : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("院校名称", releaseRecruitResume.getCollege());
            map.put("招生简章", releaseRecruitResume.getResumeTitle());
            map.put("url地址", releaseRecruitResume.getUrl());
            map.put("发布时间", releaseRecruitResume.getResumePublishDate());
            map.put("联系单位电话", releaseRecruitResume.getContactPhoneNumber());
            map.put("浏览次数", releaseRecruitResume.getBroswer());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}