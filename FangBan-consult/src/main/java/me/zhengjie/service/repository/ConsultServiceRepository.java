
package me.zhengjie.service.repository;

import me.zhengjie.service.domain.ConsultService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-27
**/
public interface ConsultServiceRepository extends JpaRepository<ConsultService, Integer>, JpaSpecificationExecutor<ConsultService> {
}