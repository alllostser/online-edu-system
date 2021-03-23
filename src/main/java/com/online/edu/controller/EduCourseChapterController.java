package com.online.edu.controller;


import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.online.edu.entity.EduCourseChapter;
import com.online.edu.service.EduCourseChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
@RestController
@RequestMapping("/course-chapter")
public class EduCourseChapterController {
    @Autowired
    private EduCourseChapterService eduCourseChapterService;

    /**
     * 添加章节
     * @param eduCourseChapter
     * @return
     */
    @PostMapping("/add")
    public R addChapter(@RequestBody EduCourseChapter eduCourseChapter){
        if (ObjectUtils.isEmpty(eduCourseChapter.getChapterType())){
            eduCourseChapter.setChapterType(1);
        }
        if (ObjectUtils.isEmpty(eduCourseChapter.getParentId())){
            eduCourseChapter.setParentId(0);
        }
        boolean save = eduCourseChapterService.save(eduCourseChapter);
        return R.ok(save);
    }

    /**
     * 删除章节
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public R deleteChapter(Integer id){
        if (id==null){
            return R.failed("参数为空！");
        }
        boolean b = eduCourseChapterService.removeById(id);
        return R.ok(b);
    }

    /**
     * 更新
     * @param eduCourseChapter
     * @return
     */
    @PostMapping("/update")
    public R updateChapter(@RequestBody EduCourseChapter eduCourseChapter){
        boolean b = eduCourseChapterService.updateById(eduCourseChapter);
        return R.ok(b);
    }
}

