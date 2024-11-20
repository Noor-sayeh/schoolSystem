package com.example.school_system;

public class T {
    String namee,gmaile,coursenamee,empssne;
    Integer numbere,stnume;

    public T(String namee,Integer numbere,String gmaile,Integer stnume,String coursenamee,String empssne) {
        this.namee = namee;
        this.coursenamee=coursenamee;
        this.empssne=empssne;
        this.gmaile=gmaile;
        this.numbere=numbere;
        this.stnume=stnume;
    }

    public String getNamee() {
        return namee;
    }

    public String getGmaile() {
        return gmaile;
    }

    public Integer getNumbere() {
        return numbere;
    }

    public void setStnume(Integer stnume) {
        this.stnume = stnume;
    }

    public void setNumbere(Integer numbere) {
        this.numbere = numbere;
    }

    public void setEmpssne(String empssne) {
        this.empssne = empssne;
    }

    public void setCoursenamee(String coursenamee) {
        this.coursenamee = coursenamee;
    }

    public void setGmaile(String gmaile) {
        this.gmaile = gmaile;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public Integer getStnume() {
        return stnume;
    }

    public String getEmpssne() {
        return empssne;
    }

    public String getCoursenamee() {
        return coursenamee;
    }
}
