
package me.zhengjie.enrollmentUnit.repository;

import me.zhengjie.enrollmentUnit.domain.ReleaseEnrollmentUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-01
**/
public interface ReleaseEnrollmentUnitRepository extends JpaRepository<ReleaseEnrollmentUnit, Long>, JpaSpecificationExecutor<ReleaseEnrollmentUnit> {
}