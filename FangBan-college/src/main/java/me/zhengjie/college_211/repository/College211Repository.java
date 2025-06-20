
package me.zhengjie.college_211.repository;

import me.zhengjie.college_211.domain.College211;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-16
**/
public interface College211Repository extends JpaRepository<College211, Integer>, JpaSpecificationExecutor<College211> {
}