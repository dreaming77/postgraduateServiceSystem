
package me.zhengjie.speciality_professional.repository;

import me.zhengjie.speciality_professional.domain.SpecialityProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-17
**/
public interface SpecialityProfessionalRepository extends JpaRepository<SpecialityProfessional, Integer>, JpaSpecificationExecutor<SpecialityProfessional> {
}