
package me.zhengjie.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.system.domain.DictDetail;
import me.zhengjie.modules.system.service.DictDetailService;
import me.zhengjie.modules.system.service.dto.DictDetailDto;
import me.zhengjie.modules.system.service.dto.DictDetailQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@Api(tags = "系统：字典详情管理")
@RequestMapping("/api/dictDetail")
public class DictDetailController {

    private final DictDetailService dictDetailService;
    private static final String ENTITY_NAME = "dictDetail";

    @ApiOperation("查询字典详情")
    @GetMapping
    public ResponseEntity<Object> queryDictDetail(DictDetailQueryCriteria criteria,
                                         @PageableDefault(sort = {"dictSort"}, direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(dictDetailService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @ApiOperation("查询多个字典详情")
    @GetMapping(value = "/map")
    public ResponseEntity<Object> getDictDetailMaps(@RequestParam String dictName){
        String[] names = dictName.split("[,，]");
        Map<String, List<DictDetailDto>> dictMap = new HashMap<>(16);
        for (String name : names) {
            dictMap.put(name, dictDetailService.getDictByName(name));
        }
        return new ResponseEntity<>(dictMap, HttpStatus.OK);
    }

    @Log("新增字典详情")
    @ApiOperation("新增字典详情")
    @PostMapping
    @PreAuthorize("@el.check('dict:add')")
    public ResponseEntity<Object> createDictDetail(@Validated @RequestBody DictDetail resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        dictDetailService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改字典详情")
    @ApiOperation("修改字典详情")
    @PutMapping
    @PreAuthorize("@el.check('dict:edit')")
    public ResponseEntity<Object> updateDictDetail(@Validated(DictDetail.Update.class) @RequestBody DictDetail resources){
        dictDetailService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除字典详情")
    @ApiOperation("删除字典详情")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@el.check('dict:del')")
    public ResponseEntity<Object> deleteDictDetail(@PathVariable Long id){
        dictDetailService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}