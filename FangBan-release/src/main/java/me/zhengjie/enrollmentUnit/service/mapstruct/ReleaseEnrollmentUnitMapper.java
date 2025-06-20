
package me.zhengjie.enrollmentUnit.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.enrollmentUnit.domain.ReleaseEnrollmentUnit;
import me.zhengjie.enrollmentUnit.service.dto.ReleaseEnrollmentUnitDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-01
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReleaseEnrollmentUnitMapper extends BaseMapper<ReleaseEnrollmentUnitDto, ReleaseEnrollmentUnit> {

}