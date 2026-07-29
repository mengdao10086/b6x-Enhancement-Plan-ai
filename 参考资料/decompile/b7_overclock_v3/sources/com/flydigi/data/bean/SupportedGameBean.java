package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.i3;
import androidx.room.j0;
import androidx.room.m1;
import androidx.room.u0;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@u0(tableName = "supported_game")
public class SupportedGameBean implements Parcelable {
    public static final Parcelable.Creator<SupportedGameBean> CREATOR = new Parcelable.Creator<SupportedGameBean>() { // from class: com.flydigi.data.bean.SupportedGameBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SupportedGameBean createFromParcel(Parcel in2) {
            return new SupportedGameBean(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SupportedGameBean[] newArray(int size) {
            return new SupportedGameBean[size];
        }
    };

    @SerializedName("game_name")
    @j0(name = "game_name")
    private String gameName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @m1
    private long f14342id;

    @SerializedName("support_native")
    @j0(name = "support_native")
    private boolean isSupportNative;

    @SerializedName("pkgname")
    @j0(index = true, name = "package_name")
    private String packageName;

    @i3({v6.a.class})
    private List<String> pattern;
    private String thumb;

    public SupportedGameBean(Parcel in2) {
        this.f14342id = in2.readLong();
        this.gameName = in2.readString();
        this.packageName = in2.readString();
        this.thumb = in2.readString();
        this.pattern = in2.createStringArrayList();
        this.isSupportNative = in2.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getGameName() {
        return this.gameName;
    }

    public long getId() {
        return this.f14342id;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public List<String> getPattern() {
        return this.pattern;
    }

    public String getThumb() {
        return this.thumb;
    }

    public boolean isSupportNative() {
        return this.isSupportNative;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setId(long id2) {
        this.f14342id = id2;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPattern(List<String> pattern) {
        this.pattern = pattern;
    }

    public void setSupportNative(boolean supportNative) {
        this.isSupportNative = supportNative;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String toString() {
        return "SupportedGameBean{id=" + this.f14342id + ", gameName='" + this.gameName + "', packageName='" + this.packageName + "', thumb='" + this.thumb + "', pattern=" + this.pattern + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f14342id);
        parcel.writeString(this.gameName);
        parcel.writeString(this.packageName);
        parcel.writeString(this.thumb);
        parcel.writeStringList(this.pattern);
        parcel.writeByte(this.isSupportNative ? (byte) 1 : (byte) 0);
    }

    public SupportedGameBean() {
    }
}
