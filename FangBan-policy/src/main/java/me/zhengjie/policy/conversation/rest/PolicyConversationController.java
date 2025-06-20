
package me.zhengjie.policy.conversation.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.policy.conversation.domain.PolicyConversation;
import me.zhengjie.policy.conversation.service.PolicyConversationService;
import me.zhengjie.policy.conversation.service.dto.PolicyConversationQueryCriteria;
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
@Api(tags = "研招访谈管理")
@RequestMapping("/api/policyConversation")
public class PolicyConversationController {

    private final PolicyConversationService policyConversationService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('policyConversation:list')")
    public void exportPolicyConversation(HttpServletResponse response, PolicyConversationQueryCriteria criteria) throws IOException {
        policyConversationService.download(policyConversationService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询研招访谈")
    @ApiOperation("查询研招访谈")
    @PreAuthorize("@el.check('policyConversation:list')")
    public ResponseEntity<Object> queryPolicyConversation(PolicyConversationQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(policyConversationService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增研招访谈")
    @ApiOperation("新增研招访谈")
    @PreAuthorize("@el.check('policyConversation:add')")
    public ResponseEntity<Object> createPolicyConversation(@Validated @RequestBody PolicyConversation resources){
        return new ResponseEntity<>(policyConversationService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改研招访谈")
    @ApiOperation("修改研招访谈")
    @PreAuthorize("@el.check('policyConversation:edit')")
    public ResponseEntity<Object> updatePolicyConversation(@Validated @RequestBody PolicyConversation resources){
        policyConversationService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除研招访谈")
    @ApiOperation("删除研招访谈")
    @PreAuthorize("@el.check('policyConversation:del')")
    public ResponseEntity<Object> deletePolicyConversation(@RequestBody Integer[] ids) {
        policyConversationService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}