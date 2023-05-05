package com.example.gccstudent.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.gccstudent.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author icic
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
