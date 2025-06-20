
package me.zhengjie.college_985.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.college_985.domain.College985;
import me.zhengjie.college_985.service.College985Service;
import me.zhengjie.college_985.service.dto.College985QueryCriteria;
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
@Api(tags = "985院校管理")
@RequestMapping("/api/college985")
public class College985Controller {

    private final College985Service college985Service;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('college985:list')")
    public void exportCollege985(HttpServletResponse response, College985QueryCriteria criteria) throws IOException {
        college985Service.download(college985Service.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询985院校")
    @ApiOperation("查询985院校")
    @PreAuthorize("@el.check('college985:list')")
    public ResponseEntity<Object> queryCollege985(College985QueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(college985Service.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增985院校")
    @ApiOperation("新增985院校")
    @PreAuthorize("@el.check('college985:add')")
    public ResponseEntity<Object> createCollege985(@Validated @RequestBody College985 resources){
        return new ResponseEntity<>(college985Service.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改985院校")
    @ApiOperation("修改985院校")
    @PreAuthorize("@el.check('college985:edit')")
    public ResponseEntity<Object> updateCollege985(@Validated @RequestBody College985 resources){
        college985Service.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除985院校")
    @ApiOperation("删除985院校")
    @PreAuthorize("@el.check('college985:del')")
    public ResponseEntity<Object> deleteCollege985(@RequestBody Integer[] ids) {
        college985Service.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}