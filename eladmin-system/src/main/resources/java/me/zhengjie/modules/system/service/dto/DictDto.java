
package me.zhengjie.modules.system.service.dto;

import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseDTO;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class DictDto extends BaseDTO implements Serializable {

    private Long id;

    private List<DictDetailDto> dictDetails;

    private String name;

    private String description;
}
