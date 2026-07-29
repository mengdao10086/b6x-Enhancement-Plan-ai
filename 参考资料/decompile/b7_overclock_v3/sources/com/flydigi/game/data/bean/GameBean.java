package com.flydigi.game.data.bean;

import com.blankj.utilcode.util.f1;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.flydigi.game.data.StringListConverter;
import com.google.gson.annotations.SerializedName;
import io.objectbox.annotation.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import ki.c;
import ki.e;
import ki.g;
import ki.m;

/* JADX INFO: loaded from: classes7.dex */
@Entity
public class GameBean implements MultiItemEntity, Serializable {
    public static final int STATE_DOWNLOAD_NOT_FINISHED = 1;
    public static final int STATE_INSTALLED = 2;
    public static final int STATE_NEED_INSTALL = 3;
    public static final int STATE_ORDER = 4;
    public static final int STATE_ORDERED = 5;
    public static final int TYPE_GAME_ITEM = 1;
    public static final int TYPE_GAME_NOTICE = 2;

    @SerializedName("appointment_status")
    public int appointmentStatus;

    @m
    public String catId;

    @m
    public String catName;

    @c(converter = StringListConverter.class, dbType = String.class)
    public List<String> category;
    public String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f15815id;

    @e
    public long idDB;
    public boolean installed;

    @SerializedName("is_subscribe")
    public int isSubscribed;
    public long lastOperateTime;
    public String link;
    public String localPath;
    public String log;

    @SerializedName("pkgname")
    @g
    public String packageName;

    @c(converter = StringListConverter.class, dbType = String.class)
    public List<String> pattern;
    public String size;
    public int star;
    public String thumb;
    public String title;
    public boolean updateAble;

    @SerializedName("update_time")
    public long updateTime;
    public String version;

    @SerializedName("myversion")
    public int versionCode;
    public int type = 1;
    public float progress = -1.0f;
    public boolean wifiRequired = true;
    public boolean isHide = false;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GameBean gameBean = (GameBean) obj;
        return this.idDB == gameBean.idDB && this.star == gameBean.star && this.type == gameBean.type && Objects.equals(this.f15815id, gameBean.f15815id) && Objects.equals(this.title, gameBean.title) && Objects.equals(this.packageName, gameBean.packageName) && Objects.equals(this.thumb, gameBean.thumb) && Objects.equals(this.description, gameBean.description) && Objects.equals(this.link, gameBean.link) && Objects.equals(Integer.valueOf(this.appointmentStatus), Integer.valueOf(gameBean.appointmentStatus)) && Objects.equals(Integer.valueOf(this.isSubscribed), Integer.valueOf(gameBean.isSubscribed)) && Objects.equals(this.size, gameBean.size) && Objects.equals(this.category, gameBean.category) && Objects.equals(this.catName, gameBean.catName) && Objects.equals(this.catId, gameBean.catId);
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

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.idDB), this.f15815id, this.title, this.packageName, this.thumb, Integer.valueOf(this.star), this.description, this.link, this.size, this.category, Integer.valueOf(this.type), this.catName, this.catId, Integer.valueOf(this.appointmentStatus), Integer.valueOf(this.isSubscribed));
    }

    public String toString() {
        return "GameBean{id=" + this.f15815id + ", title='" + this.title + "', lastOperateTime='" + f1.b(f1.N0(this.lastOperateTime)) + "', thumb='" + this.thumb + "', star=" + this.star + ", description='" + this.description + "', link='" + this.link + "', size='" + this.size + "', appointmentStatus='" + this.appointmentStatus + "', isSubscribed='" + this.isSubscribed + "', category='" + this.category + "', type=" + this.type + ", catName='" + this.catName + "', catId='" + this.catId + "'}";
    }
}
