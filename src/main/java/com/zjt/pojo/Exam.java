package com.zjt.pojo;

public class Exam {
    private Integer tid;

    private String title;

    private String ca;

    private String cb;

    private String cc;

    private String cd;

    private String answer;

    private String type;

    private Integer score;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca == null ? null : ca.trim();
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb == null ? null : cb.trim();
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc == null ? null : cc.trim();
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd == null ? null : cd.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}