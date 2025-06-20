
package me.zhengjie.policy.conversation.service.mapstruct;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.policy.conversation.domain.PolicyConversation;
import me.zhengjie.policy.conversation.service.dto.PolicyConversationDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-29
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PolicyConversationMapper extends BaseMapper<PolicyConversationDto, PolicyConversation> {

}