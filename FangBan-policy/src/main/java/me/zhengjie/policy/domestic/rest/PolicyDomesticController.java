
package me.zhengjie.policy.domestic.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.policy.domestic.domain.PolicyDomestic;
import me.zhengjie.policy.domestic.service.PolicyDomesticService;
import me.zhengjie.policy.domestic.service.dto.PolicyDomesticQueryCriteria;
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
@Api(tags = "国内政策管理")
@RequestMapping("/api/policyDomestic")
public class PolicyDomesticController {

    private final PolicyDomesticService policyDomesticService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('policyDomestic:list')")
    public void exportPolicyDomestic(HttpServletResponse response, PolicyDomesticQueryCriteria criteria) throws IOException {
        policyDomesticService.download(policyDomesticService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询国内政策")
    @ApiOperation("查询国内政策")
    @PreAuthorize("@el.check('policyDomestic:list')")
    public ResponseEntity<Object> queryPolicyDomestic(PolicyDomesticQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(policyDomesticService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增国内政策")
    @ApiOperation("新增国内政策")
    @PreAuthorize("@el.check('policyDomestic:add')")
    public ResponseEntity<Object> createPolicyDomestic(@Validated @RequestBody PolicyDomestic resources){
        return new ResponseEntity<>(policyDomesticService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改国内政策")
    @ApiOperation("修改国内政策")
    @PreAuthorize("@el.check('policyDomestic:edit')")
    public ResponseEntity<Object> updatePolicyDomestic(@Validated @RequestBody PolicyDomestic resources){
        policyDomesticService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除国内政策")
    @ApiOperation("删除国内政策")
    @PreAuthorize("@el.check('policyDomestic:del')")
    public ResponseEntity<Object> deletePolicyDomestic(@RequestBody Integer[] ids) {
        policyDomesticService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}