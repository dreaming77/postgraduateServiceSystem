
package me.zhengjie.college_211.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.college_211.domain.College211;
import me.zhengjie.college_211.service.College211Service;
import me.zhengjie.college_211.service.dto.College211QueryCriteria;
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
@Api(tags = "211院校管理")
@RequestMapping("/api/college211")
public class College211Controller {

    private final College211Service college211Service;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('college211:list')")
    public void exportCollege211(HttpServletResponse response, College211QueryCriteria criteria) throws IOException {
        college211Service.download(college211Service.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询211院校")
    @ApiOperation("查询211院校")
    @PreAuthorize("@el.check('college211:list')")
    public ResponseEntity<Object> queryCollege211(College211QueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(college211Service.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增211院校")
    @ApiOperation("新增211院校")
    @PreAuthorize("@el.check('college211:add')")
    public ResponseEntity<Object> createCollege211(@Validated @RequestBody College211 resources){
        return new ResponseEntity<>(college211Service.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改211院校")
    @ApiOperation("修改211院校")
    @PreAuthorize("@el.check('college211:edit')")
    public ResponseEntity<Object> updateCollege211(@Validated @RequestBody College211 resources){
        college211Service.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除211院校")
    @ApiOperation("删除211院校")
    @PreAuthorize("@el.check('college211:del')")
    public ResponseEntity<Object> deleteCollege211(@RequestBody Integer[] ids) {
        college211Service.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}