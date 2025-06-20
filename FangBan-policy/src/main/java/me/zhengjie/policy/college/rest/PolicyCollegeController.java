
package me.zhengjie.policy.college.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.policy.college.domain.PolicyCollege;
import me.zhengjie.policy.college.service.PolicyCollegeService;
import me.zhengjie.policy.college.service.dto.PolicyCollegeQueryCriteria;
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
* @date 2023-05-29
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "院校政策管理")
@RequestMapping("/api/policyCollege")
public class PolicyCollegeController {

    private final PolicyCollegeService policyCollegeService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('policyCollege:list')")
    public void exportPolicyCollege(HttpServletResponse response, PolicyCollegeQueryCriteria criteria) throws IOException {
        policyCollegeService.download(policyCollegeService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询院校政策")
    @ApiOperation("查询院校政策")
    @PreAuthorize("@el.check('policyCollege:list')")
    public ResponseEntity<Object> queryPolicyCollege(PolicyCollegeQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(policyCollegeService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增院校政策")
    @ApiOperation("新增院校政策")
    @PreAuthorize("@el.check('policyCollege:add')")
    public ResponseEntity<Object> createPolicyCollege(@Validated @RequestBody PolicyCollege resources){
        return new ResponseEntity<>(policyCollegeService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改院校政策")
    @ApiOperation("修改院校政策")
    @PreAuthorize("@el.check('policyCollege:edit')")
    public ResponseEntity<Object> updatePolicyCollege(@Validated @RequestBody PolicyCollege resources){
        policyCollegeService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除院校政策")
    @ApiOperation("删除院校政策")
    @PreAuthorize("@el.check('policyCollege:del')")
    public ResponseEntity<Object> deletePolicyCollege(@RequestBody Integer[] ids) {
        policyCollegeService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}