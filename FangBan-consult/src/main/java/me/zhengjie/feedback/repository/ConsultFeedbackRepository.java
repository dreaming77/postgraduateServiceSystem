
package me.zhengjie.feedback.repository;

import me.zhengjie.feedback.domain.ConsultFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-27
**/
public interface ConsultFeedbackRepository extends JpaRepository<ConsultFeedback, Integer>, JpaSpecificationExecutor<ConsultFeedback> {
}