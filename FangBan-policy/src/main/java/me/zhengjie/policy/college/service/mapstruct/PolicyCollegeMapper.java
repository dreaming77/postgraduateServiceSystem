
package me.zhengjie.policy.college.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.policy.college.domain.PolicyCollege;
import me.zhengjie.policy.college.service.dto.PolicyCollegeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-29
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PolicyCollegeMapper extends BaseMapper<PolicyCollegeDto, PolicyCollege> {

}