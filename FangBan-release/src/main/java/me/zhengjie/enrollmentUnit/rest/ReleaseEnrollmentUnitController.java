
package me.zhengjie.enrollmentUnit.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.enrollmentUnit.domain.ReleaseEnrollmentUnit;
import me.zhengjie.enrollmentUnit.service.ReleaseEnrollmentUnitService;
import me.zhengjie.enrollmentUnit.service.dto.ReleaseEnrollmentUnitQueryCriteria;
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
* @date 2023-05-01
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "招生单位发布管理")
@RequestMapping("/api/releaseEnrollmentUnit")
public class ReleaseEnrollmentUnitController {

    private final ReleaseEnrollmentUnitService releaseEnrollmentUnitService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('releaseEnrollmentUnit:list')")
    public void exportReleaseEnrollmentUnit(HttpServletResponse response, ReleaseEnrollmentUnitQueryCriteria criteria) throws IOException {
        releaseEnrollmentUnitService.download(releaseEnrollmentUnitService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询招生单位发布")
    @ApiOperation("查询招生单位发布")
    @PreAuthorize("@el.check('releaseEnrollmentUnit:list')")
    public ResponseEntity<Object> queryReleaseEnrollmentUnit(ReleaseEnrollmentUnitQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(releaseEnrollmentUnitService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增招生单位发布")
    @ApiOperation("新增招生单位发布")
    @PreAuthorize("@el.check('releaseEnrollmentUnit:add')")
    public ResponseEntity<Object> createReleaseEnrollmentUnit(@Validated @RequestBody ReleaseEnrollmentUnit resources){
        return new ResponseEntity<>(releaseEnrollmentUnitService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改招生单位发布")
    @ApiOperation("修改招生单位发布")
    @PreAuthorize("@el.check('releaseEnrollmentUnit:edit')")
    public ResponseEntity<Object> updateReleaseEnrollmentUnit(@Validated @RequestBody ReleaseEnrollmentUnit resources){
        releaseEnrollmentUnitService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除招生单位发布")
    @ApiOperation("删除招生单位发布")
    @PreAuthorize("@el.check('releaseEnrollmentUnit:del')")
    public ResponseEntity<Object> deleteReleaseEnrollmentUnit(@RequestBody Long[] ids) {
        releaseEnrollmentUnitService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}