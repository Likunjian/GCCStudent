package com.example.gccstudent.services;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gccstudent.domain.Student;


/**
 * @author icic
 */

public interface StudentService extends IService<Student> {

    IPage<Student> getPage(int currentPage, int pageSize);
    IPage<Student> getPage(int currentPage, int pageSize,Student student);

}
