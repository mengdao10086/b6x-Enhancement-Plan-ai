package com.flydigi.game.data.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class GameDetailBean {

    @SerializedName("appointment_status")
    public int appointmentStatus;
    public long create_time;
    public String description;
    public int down_num;
    public Gift gift;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f15818id;
    public List<String> images;
    public boolean installed;

    @SerializedName("is_subscribe")
    public int isSubscribed;
    public String link;
    public String localPath;
    public String notice;
    public String pkgname;
    public float progress;

    /* JADX INFO: renamed from: qq, reason: collision with root package name */
    public String f15819qq;
    public String size;
    public int star;
    public String tag;
    public String thumb;
    public String title;
    public boolean updateAble;
    public long update_time;
    public String version;
    public int weight;
    public boolean wifiRequired = true;

    public static class Gift {
        public String gift;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f15820id;

        public String toString() {
            return "Gift{gift='" + this.gift + "', id='" + this.f15820id + "'}";
        }
    }

    public GameBean convertGameBean() {
        GameBean gameBean = new GameBean();
        gameBean.packageName = this.pkgname;
        gameBean.f15815id = this.f15818id;
        gameBean.updateTime = this.update_time;
        gameBean.title = this.title;
        gameBean.thumb = this.thumb;
        gameBean.star = this.star;
        gameBean.description = this.description;
        gameBean.link = this.link;
        gameBean.size = this.size;
        gameBean.progress = this.progress;
        gameBean.installed = this.installed;
        gameBean.updateAble = this.updateAble;
        gameBean.localPath = this.localPath;
        gameBean.wifiRequired = this.wifiRequired;
        return gameBean;
    }

    public int getCurrentState() {
        if (this.installed) {
            return 2;
        }
        if (this.appointmentStatus == 1) {
            return this.isSubscribed == 1 ? 5 : 4;
        }
        float f10 = this.progress;
        if (f10 <= 0.0f || f10 >= 100.0f) {
            return f10 == 100.0f ? 3 : -1;
        }
        return 1;
    }

    public String toString() {
        return "GameDetailBean{id='" + this.f15818id + "', create_time=" + this.create_time + ", update_time=" + this.update_time + ", title='" + this.title + "', thumb='" + this.thumb + "', tag='" + this.tag + "', version='" + this.version + "', pkgname='" + this.pkgname + "', qq='" + this.f15819qq + "', weight=" + this.weight + ", star=" + this.star + ", description='" + this.description + "', link='" + this.link + "', size='" + this.size + "', images=" + this.images + ", down_num=" + this.down_num + ", notice='" + this.notice + "', gift=" + this.gift + ", localPath='" + this.localPath + "'}";
    }
}
