package com.example.gccstudent.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gccstudent.dao.StudentDao;
import com.example.gccstudent.domain.Student;
import com.example.gccstudent.services.StudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author icic
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        studentDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize, Student student) {
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<Student>();
        lqw.like(Strings.isNotEmpty(student.getClazz()),Student::getClazz,student.getClazz());
        lqw.like(Strings.isNotEmpty(student.getName()),Student::getName,student.getName());
        lqw.like(Strings.isNotEmpty(student.getNum()),Student::getNum,student.getNum());
        lqw.like(Strings.isNotEmpty(student.getGrade()),Student::getGrade,student.getGrade());
        IPage<Student> page = new Page(currentPage,pageSize);
        studentDao.selectPage(page,lqw);
        return page;
    }
}
