
package me.zhengjie.college_985.repository;

import me.zhengjie.college_985.domain.College985;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-16
**/
public interface College985Repository extends JpaRepository<College985, Integer>, JpaSpecificationExecutor<College985> {
}