
package me.zhengjie.modules.mnt.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.mnt.domain.Deploy;
import me.zhengjie.modules.mnt.service.dto.DeployDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",uses = {AppMapper.class, ServerDeployMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeployMapper extends BaseMapper<DeployDto, Deploy> {

}
