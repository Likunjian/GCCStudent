package com.example.gccstudent.controller.untils;

import lombok.Data;

@Data
public class Result {
    private Boolean flag;
    private Object data;
    private String msg;
    public Result(Boolean flag){
        this.flag = flag;
    }

    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result() {
    }

    public Result(String msg){
        this.flag = false;
        this.msg = msg;
    }

    public Result(Boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }
}
