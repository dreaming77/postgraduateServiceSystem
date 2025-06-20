
package me.zhengjie.gen.repository;

import me.zhengjie.gen.domain.ConsultList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-19
**/
public interface ConsultListRepository extends JpaRepository<ConsultList, Integer>, JpaSpecificationExecutor<ConsultList> {
}