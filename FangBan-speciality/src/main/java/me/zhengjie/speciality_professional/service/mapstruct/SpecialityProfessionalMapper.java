
package me.zhengjie.speciality_professional.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.speciality_professional.domain.SpecialityProfessional;
import me.zhengjie.speciality_professional.service.dto.SpecialityProfessionalDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-17
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpecialityProfessionalMapper extends BaseMapper<SpecialityProfessionalDto, SpecialityProfessional> {

}