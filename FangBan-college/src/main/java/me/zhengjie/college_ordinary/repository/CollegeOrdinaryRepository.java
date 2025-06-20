
package me.zhengjie.college_ordinary.repository;

import me.zhengjie.college_ordinary.domain.CollegeOrdinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-16
**/
public interface CollegeOrdinaryRepository extends JpaRepository<CollegeOrdinary, Integer>, JpaSpecificationExecutor<CollegeOrdinary> {
}