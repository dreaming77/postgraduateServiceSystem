
package me.zhengjie.speciality_academic.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.speciality_academic.domain.SpecialityAcademic;
import me.zhengjie.speciality_academic.service.SpecialityAcademicService;
import me.zhengjie.speciality_academic.service.dto.SpecialityAcademicQueryCriteria;
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
* @date 2023-05-17
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "学术性管理")
@RequestMapping("/api/specialityAcademic")
public class SpecialityAcademicController {

    private final SpecialityAcademicService specialityAcademicService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('specialityAcademic:list')")
    public void exportSpecialityAcademic(HttpServletResponse response, SpecialityAcademicQueryCriteria criteria) throws IOException {
        specialityAcademicService.download(specialityAcademicService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询学术性")
    @ApiOperation("查询学术性")
    @PreAuthorize("@el.check('specialityAcademic:list')")
    public ResponseEntity<Object> querySpecialityAcademic(SpecialityAcademicQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(specialityAcademicService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增学术性")
    @ApiOperation("新增学术性")
    @PreAuthorize("@el.check('specialityAcademic:add')")
    public ResponseEntity<Object> createSpecialityAcademic(@Validated @RequestBody SpecialityAcademic resources){
        return new ResponseEntity<>(specialityAcademicService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改学术性")
    @ApiOperation("修改学术性")
    @PreAuthorize("@el.check('specialityAcademic:edit')")
    public ResponseEntity<Object> updateSpecialityAcademic(@Validated @RequestBody SpecialityAcademic resources){
        specialityAcademicService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除学术性")
    @ApiOperation("删除学术性")
    @PreAuthorize("@el.check('specialityAcademic:del')")
    public ResponseEntity<Object> deleteSpecialityAcademic(@RequestBody Integer[] ids) {
        specialityAcademicService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}