
package me.zhengjie.provincialRecruitmentOffice.repository;

import me.zhengjie.provincialRecruitmentOffice.domain.ReleaseProvincialOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-01
**/
public interface ReleaseProvincialOfficeRepository extends JpaRepository<ReleaseProvincialOffice, Integer>, JpaSpecificationExecutor<ReleaseProvincialOffice> {
}