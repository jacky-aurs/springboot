package com.example.demo.bean;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "artlist_tb")
public class artListBean {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getQishu() {
        return qishu;
    }

    public void setQishu(String qishu) {
        this.qishu = qishu;
    }

    public String getDianzan() {
        return dianzan;
    }

    public void setDianzan(String dianzan) {
        this.dianzan = dianzan;
    }

    public String getDianji() {
        return dianji;
    }

    public void setDianji(String dianji) {
        this.dianji = dianji;
    }

    public String getTopid() {
        return topid;
    }

    public void setTopid(String topid) {
        this.topid = topid;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getIs_gl() {
        return is_gl;
    }

    public void setIs_gl(String is_gl) {
        this.is_gl = is_gl;
    }

    public String getTximg() {
        return tximg;
    }

    public void setTximg(String tximg) {
        this.tximg = tximg;
    }

    public String getPlnum() {
        return plnum;
    }

    public void setPlnum(String plnum) {
        this.plnum = plnum;
    }

    public String getIs_dz() {
        return is_dz;
    }

    public void setIs_dz(String is_dz) {
        this.is_dz = is_dz;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIs_yd() {
        return is_yd;
    }

    public void setIs_yd(String is_yd) {
        this.is_yd = is_yd;
    }

    public String getDeacript() {
        return deacript;
    }

    public void setDeacript(String deacript) {
        this.deacript = deacript;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Id
    private String id;
    @Column(name = "uid")
    private String uid;
    @Column(name = "title")
    private String title;
    @Column(name = "addtime")
    private String addtime;
    @Column(name = "descript")
    private String descript;
    @Column(name = "qishu")
    private String qishu;
    @Column(name = "dianzan")
    private String dianzan;
    @Column(name = "dianji")
    private String dianji;
    @Column(name = "topid")
    private String topid;
    @Column(name = "nikename")
    private String nikename;
    @Column(name = "is_gl")
    private String is_gl;
    @Column(name = "tximg")
    private String tximg;
    @Column(name = "plnum")
    private String plnum;
    @Column(name = "is_dz")
    private String is_dz;
    @Column(name = "color")
    private String color;
    @Column(name = "is_yd")
    private String is_yd;
    @Column(name = "deacript")
    private String deacript;
    @Column(name = "url")
    private String url;

    public String getDeacripts() {
        return deacripts;
    }

    public void setDeacripts(String deacripts) {
        this.deacripts = deacripts;
    }

    @Column(name = "deacripts")
    private String deacripts;

    public artListBean() {

    }

    public artListBean(String id, String uid, String title, String addtime, String descript, String qishu, String dianzan, String dianji, String topid, String nikename, String is_gl, String tximg, String plnum, String is_dz, String color, String is_yd, String deacript, String url, String count) {
        this.id = id;
        this.uid = uid;
        this.title = title;
        this.addtime = addtime;
        this.descript = descript;
        this.qishu = qishu;
        this.dianzan = dianzan;
        this.dianji = dianji;
        this.topid = topid;
        this.nikename = nikename;
        this.is_gl = is_gl;
        this.tximg = tximg;
        this.plnum = plnum;
        this.is_dz = is_dz;
        this.color = color;
        this.is_yd = is_yd;
        this.deacript = deacript;
        this.url = url;
    }
}
