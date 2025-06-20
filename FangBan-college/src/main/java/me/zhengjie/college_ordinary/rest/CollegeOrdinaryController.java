
package me.zhengjie.college_ordinary.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.college_ordinary.domain.CollegeOrdinary;
import me.zhengjie.college_ordinary.service.CollegeOrdinaryService;
import me.zhengjie.college_ordinary.service.dto.CollegeOrdinaryQueryCriteria;
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
* @date 2023-05-16
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "普通院校管理")
@RequestMapping("/api/collegeOrdinary")
public class CollegeOrdinaryController {

    private final CollegeOrdinaryService collegeOrdinaryService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('collegeOrdinary:list')")
    public void exportCollegeOrdinary(HttpServletResponse response, CollegeOrdinaryQueryCriteria criteria) throws IOException {
        collegeOrdinaryService.download(collegeOrdinaryService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询普通院校")
    @ApiOperation("查询普通院校")
    @PreAuthorize("@el.check('collegeOrdinary:list')")
    public ResponseEntity<Object> queryCollegeOrdinary(CollegeOrdinaryQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(collegeOrdinaryService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增普通院校")
    @ApiOperation("新增普通院校")
    @PreAuthorize("@el.check('collegeOrdinary:add')")
    public ResponseEntity<Object> createCollegeOrdinary(@Validated @RequestBody CollegeOrdinary resources){
        return new ResponseEntity<>(collegeOrdinaryService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改普通院校")
    @ApiOperation("修改普通院校")
    @PreAuthorize("@el.check('collegeOrdinary:edit')")
    public ResponseEntity<Object> updateCollegeOrdinary(@Validated @RequestBody CollegeOrdinary resources){
        collegeOrdinaryService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除普通院校")
    @ApiOperation("删除普通院校")
    @PreAuthorize("@el.check('collegeOrdinary:del')")
    public ResponseEntity<Object> deleteCollegeOrdinary(@RequestBody Integer[] ids) {
        collegeOrdinaryService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}