
package me.zhengjie.speciality_academic.repository;

import me.zhengjie.speciality_academic.domain.SpecialityAcademic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-17
**/
public interface SpecialityAcademicRepository extends JpaRepository<SpecialityAcademic, Integer>, JpaSpecificationExecutor<SpecialityAcademic> {
}