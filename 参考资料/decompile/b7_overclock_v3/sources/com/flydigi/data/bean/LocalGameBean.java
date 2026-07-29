package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class LocalGameBean implements MultiItemEntity, Parcelable {
    public static final Parcelable.Creator<LocalGameBean> CREATOR = new Parcelable.Creator<LocalGameBean>() { // from class: com.flydigi.data.bean.LocalGameBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalGameBean createFromParcel(Parcel in2) {
            return new LocalGameBean(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalGameBean[] newArray(int size) {
            return new LocalGameBean[size];
        }
    };
    public static final int ITEM_TYPE_ADD_GAME = 2;
    public static final int ITEM_TYPE_GAME = 1;
    public int gameMode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public long f14331id;
    public String localPackageName;
    public String name;
    public boolean selected;
    public String shareCode;
    public String standardPackageName;
    public String thumb;
    public int type;

    public LocalGameBean() {
        this.type = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        LocalGameBean localGameBean = (LocalGameBean) o10;
        return this.type == localGameBean.type && this.f14331id == localGameBean.f14331id && this.selected == localGameBean.selected && this.gameMode == localGameBean.gameMode && Objects.equals(this.thumb, localGameBean.thumb) && Objects.equals(this.localPackageName, localGameBean.localPackageName) && Objects.equals(this.standardPackageName, localGameBean.standardPackageName) && Objects.equals(this.name, localGameBean.name) && Objects.equals(this.shareCode, localGameBean.shareCode);
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public long getId() {
        return this.f14331id;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public String getLocalPackageName() {
        return this.localPackageName;
    }

    public String getName() {
        return this.name;
    }

    public String getStandardPackageName() {
        return this.standardPackageName;
    }

    public String getThumb() {
        return this.thumb;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.type), Long.valueOf(this.f14331id), this.thumb, this.localPackageName, this.standardPackageName, this.name, Boolean.valueOf(this.selected), Integer.valueOf(this.gameMode), this.shareCode);
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public void setId(long id2) {
        this.f14331id = id2;
    }

    public void setLocalPackageName(String localPackageName) {
        this.localPackageName = localPackageName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setStandardPackageName(String standardPackageName) {
        this.standardPackageName = standardPackageName;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        return "LocalGameBean{type=" + this.type + ", id=" + this.f14331id + ", thumb='" + this.thumb + "', localPackageName='" + this.localPackageName + "', standardPackageName='" + this.standardPackageName + "', name='" + this.name + "', selected=" + this.selected + ", gameMode=" + this.gameMode + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.type);
        parcel.writeLong(this.f14331id);
        parcel.writeString(this.thumb);
        parcel.writeString(this.localPackageName);
        parcel.writeString(this.standardPackageName);
        parcel.writeString(this.name);
        parcel.writeByte(this.selected ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.gameMode);
        parcel.writeString(this.shareCode);
    }

    public LocalGameBean(Parcel in2) {
        this.type = 1;
        this.type = in2.readInt();
        this.f14331id = in2.readLong();
        this.thumb = in2.readString();
        this.localPackageName = in2.readString();
        this.standardPackageName = in2.readString();
        this.name = in2.readString();
        this.selected = in2.readByte() != 0;
        this.gameMode = in2.readInt();
        this.shareCode = in2.readString();
    }
}
