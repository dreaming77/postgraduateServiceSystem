
package me.zhengjie.provincialRecruitmentOffice.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.provincialRecruitmentOffice.domain.ReleaseProvincialOffice;
import me.zhengjie.provincialRecruitmentOffice.service.ReleaseProvincialOfficeService;
import me.zhengjie.provincialRecruitmentOffice.service.dto.ReleaseProvincialOfficeQueryCriteria;
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
@Api(tags = "省招办发布管理")
@RequestMapping("/api/releaseProvincialOffice")
public class ReleaseProvincialOfficeController {

    private final ReleaseProvincialOfficeService releaseProvincialOfficeService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('releaseProvincialOffice:list')")
    public void exportReleaseProvincialOffice(HttpServletResponse response, ReleaseProvincialOfficeQueryCriteria criteria) throws IOException {
        releaseProvincialOfficeService.download(releaseProvincialOfficeService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询省招办发布")
    @ApiOperation("查询省招办发布")
    @PreAuthorize("@el.check('releaseProvincialOffice:list')")
    public ResponseEntity<Object> queryReleaseProvincialOffice(ReleaseProvincialOfficeQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(releaseProvincialOfficeService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增省招办发布")
    @ApiOperation("新增省招办发布")
    @PreAuthorize("@el.check('releaseProvincialOffice:add')")
    public ResponseEntity<Object> createReleaseProvincialOffice(@Validated @RequestBody ReleaseProvincialOffice resources){
        return new ResponseEntity<>(releaseProvincialOfficeService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改省招办发布")
    @ApiOperation("修改省招办发布")
    @PreAuthorize("@el.check('releaseProvincialOffice:edit')")
    public ResponseEntity<Object> updateReleaseProvincialOffice(@Validated @RequestBody ReleaseProvincialOffice resources){
        releaseProvincialOfficeService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除省招办发布")
    @ApiOperation("删除省招办发布")
    @PreAuthorize("@el.check('releaseProvincialOffice:del')")
    public ResponseEntity<Object> deleteReleaseProvincialOffice(@RequestBody Integer[] ids) {
        releaseProvincialOfficeService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}