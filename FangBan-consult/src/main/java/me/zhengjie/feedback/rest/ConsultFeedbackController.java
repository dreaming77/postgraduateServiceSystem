
package me.zhengjie.feedback.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.feedback.domain.ConsultFeedback;
import me.zhengjie.feedback.service.ConsultFeedbackService;
import me.zhengjie.feedback.service.dto.ConsultFeedbackQueryCriteria;
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
* @date 2023-04-27
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "用户反馈管理")
@RequestMapping("/api/consultFeedback")
public class ConsultFeedbackController {

    private final ConsultFeedbackService consultFeedbackService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('consultFeedback:list')")
    public void exportConsultFeedback(HttpServletResponse response, ConsultFeedbackQueryCriteria criteria) throws IOException {
        consultFeedbackService.download(consultFeedbackService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询用户反馈")
    @ApiOperation("查询用户反馈")
    @PreAuthorize("@el.check('consultFeedback:list')")
    public ResponseEntity<Object> queryConsultFeedback(ConsultFeedbackQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(consultFeedbackService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增用户反馈")
    @ApiOperation("新增用户反馈")
    @PreAuthorize("@el.check('consultFeedback:add')")
    public ResponseEntity<Object> createConsultFeedback(@Validated @RequestBody ConsultFeedback resources){
        return new ResponseEntity<>(consultFeedbackService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改用户反馈")
    @ApiOperation("修改用户反馈")
    @PreAuthorize("@el.check('consultFeedback:edit')")
    public ResponseEntity<Object> updateConsultFeedback(@Validated @RequestBody ConsultFeedback resources){
        consultFeedbackService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除用户反馈")
    @ApiOperation("删除用户反馈")
    @PreAuthorize("@el.check('consultFeedback:del')")
    public ResponseEntity<Object> deleteConsultFeedback(@RequestBody Integer[] ids) {
        consultFeedbackService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}