
package me.zhengjie.speciality_academic.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.speciality_academic.domain.SpecialityAcademic;
import me.zhengjie.speciality_academic.service.dto.SpecialityAcademicDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-17
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpecialityAcademicMapper extends BaseMapper<SpecialityAcademicDto, SpecialityAcademic> {

}