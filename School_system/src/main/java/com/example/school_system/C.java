package com.example.school_system;

public class C {
    String n,tnume;
    Integer nu,not;

    public C(String n,Integer nu,Integer not,String tnume) {
        this.n = n;
        this.not=not;
        this.nu=nu;
        this.tnume=tnume;
    }

    public void setTnume(String tnume) {
        this.tnume = tnume;
    }

    public void setNot(Integer not) {
        this.not = not;
    }

    public void setNu(Integer nu) {
        this.nu = nu;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getTnume() {
        return tnume;
    }

    public Integer getNot() {
        return not;
    }

    public Integer getNu() {
        return nu;
    }

    public String getN() {
        return n;
    }
}
