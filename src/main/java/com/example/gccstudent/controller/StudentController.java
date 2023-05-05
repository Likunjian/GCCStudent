package com.example.gccstudent.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.gccstudent.controller.untils.Result;
import com.example.gccstudent.domain.Student;
import com.example.gccstudent.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author icic
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result select(){
        return new Result(true,studentService.list());
    }

    @PostMapping
    public Result save(@RequestBody Student student){
        boolean flag = studentService.save(student);
        return new Result(flag,flag ? "添加成功":"添加失败");
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        boolean flag = studentService.updateById(student);
        return  new Result(flag,flag? "修改成功":"修改失败");
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        return new Result(studentService.removeById(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true,studentService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize,Student student){
        IPage<Student> page = studentService.getPage(currentPage,pageSize,student);
        if (currentPage >  page.getPages()){
            page = studentService.getPage((int) page.getPages(),pageSize,student);
        }
        return new Result(true,page);
    }

}
