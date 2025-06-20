
package me.zhengjie.machine.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.machine.domain.ConsultMachine;
import me.zhengjie.machine.service.ConsultMachineService;
import me.zhengjie.machine.service.dto.ConsultMachineQueryCriteria;
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
@Api(tags = "人机回复管理")
@RequestMapping("/api/consultMachine")
public class ConsultMachineController {

    private final ConsultMachineService consultMachineService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('consultMachine:list')")
    public void exportConsultMachine(HttpServletResponse response, ConsultMachineQueryCriteria criteria) throws IOException {
        consultMachineService.download(consultMachineService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询人机回复")
    @ApiOperation("查询人机回复")
    @PreAuthorize("@el.check('consultMachine:list')")
    public ResponseEntity<Object> queryConsultMachine(ConsultMachineQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(consultMachineService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增人机回复")
    @ApiOperation("新增人机回复")
    @PreAuthorize("@el.check('consultMachine:add')")
    public ResponseEntity<Object> createConsultMachine(@Validated @RequestBody ConsultMachine resources){
        return new ResponseEntity<>(consultMachineService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改人机回复")
    @ApiOperation("修改人机回复")
    @PreAuthorize("@el.check('consultMachine:edit')")
    public ResponseEntity<Object> updateConsultMachine(@Validated @RequestBody ConsultMachine resources){
        consultMachineService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除人机回复")
    @ApiOperation("删除人机回复")
    @PreAuthorize("@el.check('consultMachine:del')")
    public ResponseEntity<Object> deleteConsultMachine(@RequestBody Integer[] ids) {
        consultMachineService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}