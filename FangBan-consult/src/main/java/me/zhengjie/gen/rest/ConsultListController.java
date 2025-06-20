
package me.zhengjie.gen.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.gen.domain.ConsultList;
import me.zhengjie.gen.service.ConsultListService;
import me.zhengjie.gen.service.dto.ConsultListQueryCriteria;
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
* @date 2023-04-19
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "咨询列表管理")
@RequestMapping("/api/consultList")
public class ConsultListController {

    private final ConsultListService consultListService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('consultList:list')")
    public void exportConsultList(HttpServletResponse response, ConsultListQueryCriteria criteria) throws IOException {
        consultListService.download(consultListService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询咨询列表")
    @ApiOperation("查询咨询列表")
    @PreAuthorize("@el.check('consultList:list')")
    public ResponseEntity<Object> queryConsultList(ConsultListQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(consultListService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增咨询列表")
    @ApiOperation("新增咨询列表")
    @PreAuthorize("@el.check('consultList:add')")
    public ResponseEntity<Object> createConsultList(@Validated @RequestBody ConsultList resources){
        return new ResponseEntity<>(consultListService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改咨询列表")
    @ApiOperation("修改咨询列表")
    @PreAuthorize("@el.check('consultList:edit')")
    public ResponseEntity<Object> updateConsultList(@Validated @RequestBody ConsultList resources){
        consultListService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除咨询列表")
    @ApiOperation("删除咨询列表")
    @PreAuthorize("@el.check('consultList:del')")
    public ResponseEntity<Object> deleteConsultList(@RequestBody Integer[] ids) {
        consultListService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}