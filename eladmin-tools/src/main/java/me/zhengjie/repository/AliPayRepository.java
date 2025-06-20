
package me.zhengjie.repository;

import me.zhengjie.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AliPayRepository extends JpaRepository<AlipayConfig,Long> {
}
