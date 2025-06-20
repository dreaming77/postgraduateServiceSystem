
package me.zhengjie.repository;

import me.zhengjie.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
