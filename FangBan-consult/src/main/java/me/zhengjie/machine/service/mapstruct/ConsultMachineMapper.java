
package me.zhengjie.machine.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.machine.domain.ConsultMachine;
import me.zhengjie.machine.service.dto.ConsultMachineDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-27
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConsultMachineMapper extends BaseMapper<ConsultMachineDto, ConsultMachine> {

}