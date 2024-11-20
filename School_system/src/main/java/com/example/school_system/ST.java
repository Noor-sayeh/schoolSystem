package com.example.school_system;

import java.sql.Date;

public class ST {
    String NAME;
    Integer idd;
    Date bth;
    String gend;
    String pname;
    Integer pnumber;
    Integer rid;
    String mss;
    String gmail,address;

    public ST(String NAME,Integer id,Date bth,String gender,String pname,Integer pnumber,Integer rid,String mss,String gmail,String address) {
        this.NAME = NAME;
        this.idd=id;
        this.bth=bth;
        this.gend=gender;
        this.pname=pname;
        this.pnumber=pnumber;
        this.rid=rid;
        this.mss=mss;
        this.gmail=gmail;
        this.address=address;

    }

    public String getNAME() {
        return NAME;
    }

    public String getGender() {
        return gend;
    }

    public Date getBth() {
        return bth;
    }

    public Integer getId() {
        return idd;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public String getPname() {

        return pname;
    }

    public Integer getRid() {
        return rid;
    }

    public String getMss() {
        return mss;
    }

    public String getAddress() {
        return address;
    }

    public String getGmail() {
        return gmail;
    }

    public void setId(Integer id) {
        this.idd = id;
    }

    public void setBth(Date bth) {
        this.bth = bth;
    }

    public void setGender(String gender) {
        this.gend = gender;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public void setMss(String mss) {
        this.mss = mss;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}
