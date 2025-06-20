
package me.zhengjie.policy.conversation.repository;

import me.zhengjie.policy.conversation.domain.PolicyConversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-29
**/
public interface PolicyConversationRepository extends JpaRepository<PolicyConversation, Integer>, JpaSpecificationExecutor<PolicyConversation> {
}