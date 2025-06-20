
package me.zhengjie.modules.mnt.service.dto;

import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseDTO;
import java.io.Serializable;


@Getter
@Setter
public class DatabaseDto extends BaseDTO implements Serializable {

	/**
	 * id
	 */
    private String id;

	/**
	 * 数据库名称
	 */
    private String name;

	/**
	 * 数据库连接地址
	 */
    private String jdbcUrl;

	/**
	 * 数据库密码
	 */
    private String pwd;

	/**
	 * 用户名
	 */
    private String userName;
}
