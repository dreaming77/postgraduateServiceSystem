
package me.zhengjie.policy.domestic.repository;

import me.zhengjie.policy.domestic.domain.PolicyDomestic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-29
**/
public interface PolicyDomesticRepository extends JpaRepository<PolicyDomestic, Integer>, JpaSpecificationExecutor<PolicyDomestic> {
}