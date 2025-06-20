
package me.zhengjie.provincialRecruitmentOffice.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.provincialRecruitmentOffice.domain.ReleaseProvincialOffice;
import me.zhengjie.provincialRecruitmentOffice.service.dto.ReleaseProvincialOfficeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-01
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReleaseProvincialOfficeMapper extends BaseMapper<ReleaseProvincialOfficeDto, ReleaseProvincialOffice> {

}