
package me.zhengjie.college_211.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.college_211.domain.College211;
import me.zhengjie.college_211.service.dto.College211Dto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-16
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface College211Mapper extends BaseMapper<College211Dto, College211> {

}