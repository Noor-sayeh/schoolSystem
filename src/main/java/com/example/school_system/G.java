package com.example.school_system;

public class G {
    Integer Sid;
    String Cname;
    Integer Grd;

    public G(Integer Sid,Integer Grd,String Cname) {
        this.Cname = Cname;
        this.Sid=Sid;
        this.Grd=Grd;
    }

    public G() {

    }


    public Integer getSid() {
        return Sid;
    }

    public Integer getGrd() {
        return Grd;
    }

    public String getCname() {
        return Cname;
    }


    public void setSid(Integer sid) {
        Sid = sid;
    }

    public void setGrd(Integer grd) {
        Grd = grd;
    }

    public void setCname(String cname) {
        Cname = cname;
    }


}
