
package me.zhengjie.college_ordinary.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.college_ordinary.domain.CollegeOrdinary;
import me.zhengjie.college_ordinary.service.dto.CollegeOrdinaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-16
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CollegeOrdinaryMapper extends BaseMapper<CollegeOrdinaryDto, CollegeOrdinary> {

}