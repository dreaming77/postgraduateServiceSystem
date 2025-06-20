
package me.zhengjie.service.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.service.domain.ConsultService;
import me.zhengjie.service.service.ConsultServiceService;
import me.zhengjie.service.service.dto.ConsultServiceQueryCriteria;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://eladmin.vip
* @author dreaming
* @date 2023-04-27
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "人工客服管理")
@RequestMapping("/api/consultService")
public class ConsultServiceController {

    private final ConsultServiceService consultServiceService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('consultService:list')")
    public void exportConsultService(HttpServletResponse response, ConsultServiceQueryCriteria criteria) throws IOException {
        consultServiceService.download(consultServiceService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询人工客服")
    @ApiOperation("查询人工客服")
    @PreAuthorize("@el.check('consultService:list')")
    public ResponseEntity<Object> queryConsultService(ConsultServiceQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(consultServiceService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增人工客服")
    @ApiOperation("新增人工客服")
    @PreAuthorize("@el.check('consultService:add')")
    public ResponseEntity<Object> createConsultService(@Validated @RequestBody ConsultService resources){
        return new ResponseEntity<>(consultServiceService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改人工客服")
    @ApiOperation("修改人工客服")
    @PreAuthorize("@el.check('consultService:edit')")
    public ResponseEntity<Object> updateConsultService(@Validated @RequestBody ConsultService resources){
        consultServiceService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除人工客服")
    @ApiOperation("删除人工客服")
    @PreAuthorize("@el.check('consultService:del')")
    public ResponseEntity<Object> deleteConsultService(@RequestBody Integer[] ids) {
        consultServiceService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}