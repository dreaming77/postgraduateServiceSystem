
package me.zhengjie.recruitResume.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.recruitResume.domain.ReleaseRecruitResume;
import me.zhengjie.recruitResume.service.ReleaseRecruitResumeService;
import me.zhengjie.recruitResume.service.dto.ReleaseRecruitResumeQueryCriteria;
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
* @date 2023-05-02
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "招生简章管理")
@RequestMapping("/api/releaseRecruitResume")
public class ReleaseRecruitResumeController {

    private final ReleaseRecruitResumeService releaseRecruitResumeService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('releaseRecruitResume:list')")
    public void exportReleaseRecruitResume(HttpServletResponse response, ReleaseRecruitResumeQueryCriteria criteria) throws IOException {
        releaseRecruitResumeService.download(releaseRecruitResumeService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询招生简章")
    @ApiOperation("查询招生简章")
    @PreAuthorize("@el.check('releaseRecruitResume:list')")
    public ResponseEntity<Object> queryReleaseRecruitResume(ReleaseRecruitResumeQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(releaseRecruitResumeService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增招生简章")
    @ApiOperation("新增招生简章")
    @PreAuthorize("@el.check('releaseRecruitResume:add')")
    public ResponseEntity<Object> createReleaseRecruitResume(@Validated @RequestBody ReleaseRecruitResume resources){
        return new ResponseEntity<>(releaseRecruitResumeService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改招生简章")
    @ApiOperation("修改招生简章")
    @PreAuthorize("@el.check('releaseRecruitResume:edit')")
    public ResponseEntity<Object> updateReleaseRecruitResume(@Validated @RequestBody ReleaseRecruitResume resources){
        releaseRecruitResumeService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除招生简章")
    @ApiOperation("删除招生简章")
    @PreAuthorize("@el.check('releaseRecruitResume:del')")
    public ResponseEntity<Object> deleteReleaseRecruitResume(@RequestBody Integer[] ids) {
        releaseRecruitResumeService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}