
package me.zhengjie.policy.college.repository;

import me.zhengjie.policy.college.domain.PolicyCollege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-29
**/
public interface PolicyCollegeRepository extends JpaRepository<PolicyCollege, Integer>, JpaSpecificationExecutor<PolicyCollege> {
}