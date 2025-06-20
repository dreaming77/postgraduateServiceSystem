
package me.zhengjie.speciality_professional.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.speciality_professional.domain.SpecialityProfessional;
import me.zhengjie.speciality_professional.service.SpecialityProfessionalService;
import me.zhengjie.speciality_professional.service.dto.SpecialityProfessionalQueryCriteria;
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
@Api(tags = "专业型学位管理")
@RequestMapping("/api/specialityProfessional")
public class SpecialityProfessionalController {

    private final SpecialityProfessionalService specialityProfessionalService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('specialityProfessional:list')")
    public void exportSpecialityProfessional(HttpServletResponse response, SpecialityProfessionalQueryCriteria criteria) throws IOException {
        specialityProfessionalService.download(specialityProfessionalService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询专业型学位")
    @ApiOperation("查询专业型学位")
    @PreAuthorize("@el.check('specialityProfessional:list')")
    public ResponseEntity<Object> querySpecialityProfessional(SpecialityProfessionalQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(specialityProfessionalService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增专业型学位")
    @ApiOperation("新增专业型学位")
    @PreAuthorize("@el.check('specialityProfessional:add')")
    public ResponseEntity<Object> createSpecialityProfessional(@Validated @RequestBody SpecialityProfessional resources){
        return new ResponseEntity<>(specialityProfessionalService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改专业型学位")
    @ApiOperation("修改专业型学位")
    @PreAuthorize("@el.check('specialityProfessional:edit')")
    public ResponseEntity<Object> updateSpecialityProfessional(@Validated @RequestBody SpecialityProfessional resources){
        specialityProfessionalService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除专业型学位")
    @ApiOperation("删除专业型学位")
    @PreAuthorize("@el.check('specialityProfessional:del')")
    public ResponseEntity<Object> deleteSpecialityProfessional(@RequestBody Integer[] ids) {
        specialityProfessionalService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}