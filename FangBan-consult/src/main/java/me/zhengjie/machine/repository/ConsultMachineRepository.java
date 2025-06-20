
package me.zhengjie.machine.repository;

import me.zhengjie.machine.domain.ConsultMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-27
**/
public interface ConsultMachineRepository extends JpaRepository<ConsultMachine, Integer>, JpaSpecificationExecutor<ConsultMachine> {
}