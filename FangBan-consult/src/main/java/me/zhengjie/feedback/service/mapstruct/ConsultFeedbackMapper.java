
package me.zhengjie.feedback.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.feedback.domain.ConsultFeedback;
import me.zhengjie.feedback.service.dto.ConsultFeedbackDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-27
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConsultFeedbackMapper extends BaseMapper<ConsultFeedbackDto, ConsultFeedback> {

}