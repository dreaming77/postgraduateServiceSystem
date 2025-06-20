
package me.zhengjie.recruitResume.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.recruitResume.domain.ReleaseRecruitResume;
import me.zhengjie.recruitResume.service.dto.ReleaseRecruitResumeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-02
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReleaseRecruitResumeMapper extends BaseMapper<ReleaseRecruitResumeDto, ReleaseRecruitResume> {

}