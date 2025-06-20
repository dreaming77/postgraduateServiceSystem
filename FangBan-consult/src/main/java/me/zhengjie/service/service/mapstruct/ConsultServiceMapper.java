
package me.zhengjie.service.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.service.domain.ConsultService;
import me.zhengjie.service.service.dto.ConsultServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-27
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConsultServiceMapper extends BaseMapper<ConsultServiceDto, ConsultService> {

}