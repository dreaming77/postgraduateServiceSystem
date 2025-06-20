
package me.zhengjie.gen.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.gen.domain.ConsultList;
import me.zhengjie.gen.service.dto.ConsultListDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-19
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConsultListMapper extends BaseMapper<ConsultListDto, ConsultList> {

}