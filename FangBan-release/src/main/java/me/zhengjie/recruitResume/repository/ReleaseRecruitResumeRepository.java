
package me.zhengjie.recruitResume.repository;

import me.zhengjie.recruitResume.domain.ReleaseRecruitResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-05-02
**/
public interface ReleaseRecruitResumeRepository extends JpaRepository<ReleaseRecruitResume, Integer>, JpaSpecificationExecutor<ReleaseRecruitResume> {
}