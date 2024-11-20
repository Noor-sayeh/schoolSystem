package com.example.school_system;

public class R {
    String ty;
    Integer ir,sp;

    public R(String ty, Integer ir, Integer sp) {
        this.ty = ty;
        this.ir = ir;
        this.sp = sp;
    }

    public String getTy() {
        return ty;
    }

    public Integer getIr() {
        return ir;
    }

    public Integer getSp() {
        return sp;
    }

    public void setTy(String ty) {
        this.ty = ty;
    }

    public void setIr(Integer ir) {
        this.ir = ir;
    }

    public void setSp(Integer sp) {
        this.sp = sp;
    }
}
