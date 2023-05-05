package com.example.gccstudent.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("info")
public class Student {
    private long id;
    @TableField(value = "class")
    private String clazz;
    private String name;
    private String num;
    private String grade;
}
