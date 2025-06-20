
package me.zhengjie.policy.domestic.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.policy.domestic.domain.PolicyDomestic;
import me.zhengjie.policy.domestic.service.dto.PolicyDomesticDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-29
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PolicyDomesticMapper extends BaseMapper<PolicyDomesticDto, PolicyDomestic> {

}