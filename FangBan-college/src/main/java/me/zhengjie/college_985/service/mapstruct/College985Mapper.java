
package me.zhengjie.college_985.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.college_985.domain.College985;
import me.zhengjie.college_985.service.dto.College985Dto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-16
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface College985Mapper extends BaseMapper<College985Dto, College985> {

}