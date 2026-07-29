package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.j0;
import androidx.room.m1;
import androidx.room.u0;
import com.google.gson.annotations.SerializedName;
import g.n0;

/* JADX INFO: loaded from: classes7.dex */
@u0(tableName = "installed_game")
public class InstalledGameBean implements Parcelable {
    public static final Parcelable.Creator<InstalledGameBean> CREATOR = new Parcelable.Creator<InstalledGameBean>() { // from class: com.flydigi.data.bean.InstalledGameBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InstalledGameBean createFromParcel(Parcel in2) {
            return new InstalledGameBean(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InstalledGameBean[] newArray(int size) {
            return new InstalledGameBean[size];
        }
    };
    public static final int GAME_MODE_FLYMAPPING = 0;
    public static final int GAME_MODE_NATIVE = 1;

    @j0(name = "game_mode")
    private int gameMode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f14330id;

    @SerializedName("support_native")
    @j0(name = "support_native")
    private boolean isSupportNative;

    @m1
    @j0(index = true, name = "local_package_name")
    @n0
    private String localPackageName;

    @j0(index = true, name = "standard_package_name")
    private String standardPackageName;
    private String thumb;
    private String title;

    @j0(name = "update_time")
    private long updateTime;

    public InstalledGameBean(Parcel in2) {
        this.localPackageName = "";
        this.gameMode = 0;
        this.f14330id = in2.readLong();
        this.title = in2.readString();
        this.localPackageName = in2.readString();
        this.standardPackageName = in2.readString();
        this.thumb = in2.readString();
        this.updateTime = in2.readLong();
        this.gameMode = in2.readInt();
        this.isSupportNative = in2.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public long getId() {
        return this.f14330id;
    }

    @n0
    public String getLocalPackageName() {
        return this.localPackageName;
    }

    public String getStandardPackageName() {
        return this.standardPackageName;
    }

    public String getThumb() {
        return this.thumb;
    }

    public String getTitle() {
        return this.title;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isSupportNative() {
        return this.isSupportNative;
    }

    public boolean isUseMappingMode() {
        return this.gameMode == 0;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public void setId(long id2) {
        this.f14330id = id2;
    }

    public void setLocalPackageName(@n0 String localPackageName) {
        this.localPackageName = localPackageName;
    }

    public void setStandardPackageName(String standardPackageName) {
        this.standardPackageName = standardPackageName;
    }

    public void setSupportNative(boolean supportNative) {
        this.isSupportNative = supportNative;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String toString() {
        return "InstalledGameBean{id=" + this.f14330id + ", title='" + this.title + "', localPackageName='" + this.localPackageName + "', standardPackageName='" + this.standardPackageName + "', thumb='" + this.thumb + "', updateTime=" + this.updateTime + ", gameMode=" + this.gameMode + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f14330id);
        parcel.writeString(this.title);
        parcel.writeString(this.localPackageName);
        parcel.writeString(this.standardPackageName);
        parcel.writeString(this.thumb);
        parcel.writeLong(this.updateTime);
        parcel.writeInt(this.gameMode);
        parcel.writeByte(this.isSupportNative ? (byte) 1 : (byte) 0);
    }

    public InstalledGameBean() {
        this.localPackageName = "";
        this.gameMode = 0;
    }
}
