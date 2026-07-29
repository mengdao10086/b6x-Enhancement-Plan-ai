package com.flydigi.sdk.gamepad.extension.config.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.r0;
import com.blankj.utilcode.util.n0;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Objects;
import m9.h;

/* JADX INFO: loaded from: classes3.dex */
public class CFGEntity implements Parcelable {
    public static final Parcelable.Creator<CFGEntity> CREATOR = new Parcelable.Creator<CFGEntity>() { // from class: com.flydigi.sdk.gamepad.extension.config.data.CFGEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGEntity createFromParcel(Parcel parcel) {
            return new CFGEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGEntity[] newArray(int i10) {
            return new CFGEntity[i10];
        }
    };
    public String desc;

    @SerializedName("gamepad")
    private String gamepad;

    @SerializedName("in_top")
    private boolean inTop;

    @SerializedName("in_use")
    private boolean inUse;
    private transient boolean isDefault;
    private transient boolean isRecommend;
    private boolean isTest;

    @SerializedName("joysticks")
    public ArrayList<CFGPropertyJS> jsList;

    @SerializedName(r0.f6237h)
    public ArrayList<CFGPropertyKey> keyList;

    @SerializedName("manufacturer")
    private String manufacturer;

    @SerializedName("macros")
    public ArrayList<CFGPropertyMacro> marcoList;

    @SerializedName("model")
    private String model;
    private String ratio;
    public int screen_edge_reset;
    public String title;

    public CFGEntity(Parcel parcel) {
        this.title = "";
        this.desc = "";
        this.isDefault = false;
        this.isRecommend = false;
        this.screen_edge_reset = 0;
        this.keyList = new ArrayList<>();
        this.jsList = new ArrayList<>();
        this.marcoList = new ArrayList<>();
        this.title = parcel.readString();
        this.desc = parcel.readString();
        this.manufacturer = parcel.readString();
        this.model = parcel.readString();
        this.gamepad = parcel.readString();
        this.inUse = parcel.readByte() != 0;
        this.inTop = parcel.readByte() != 0;
        this.isTest = parcel.readByte() != 0;
        this.ratio = parcel.readString();
        this.screen_edge_reset = parcel.readInt();
        this.keyList = parcel.createTypedArrayList(CFGPropertyKey.CREATOR);
        this.jsList = parcel.createTypedArrayList(CFGPropertyJS.CREATOR);
        this.marcoList = parcel.createTypedArrayList(CFGPropertyMacro.CREATOR);
    }

    public CFGEntity copy() {
        CFGEntity cFGEntity = new CFGEntity();
        cFGEntity.gamepad = this.gamepad;
        cFGEntity.title = this.title;
        cFGEntity.desc = this.desc;
        cFGEntity.inUse = this.inUse;
        cFGEntity.inTop = this.inTop;
        cFGEntity.isTest = this.isTest;
        cFGEntity.isRecommend = this.isRecommend;
        cFGEntity.screen_edge_reset = this.screen_edge_reset;
        for (int i10 = 0; i10 < this.keyList.size(); i10++) {
            cFGEntity.keyList.add(this.keyList.get(i10).copy());
        }
        for (int i11 = 0; i11 < this.jsList.size(); i11++) {
            cFGEntity.jsList.add(this.jsList.get(i11).copy());
        }
        for (int i12 = 0; i12 < this.marcoList.size(); i12++) {
            cFGEntity.marcoList.add(this.marcoList.get(i12).copy());
        }
        return cFGEntity;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CFGEntity cFGEntity = (CFGEntity) obj;
        return this.screen_edge_reset == cFGEntity.screen_edge_reset && Objects.equals(this.title, cFGEntity.title) && Objects.equals(this.keyList, cFGEntity.keyList) && Objects.equals(this.jsList, cFGEntity.jsList) && Objects.equals(this.marcoList, cFGEntity.marcoList);
    }

    public String getDesc() {
        return this.desc;
    }

    public String getGamepad() {
        return this.gamepad;
    }

    public ArrayList<CFGPropertyJS> getJsList() {
        return this.jsList;
    }

    public ArrayList<CFGPropertyKey> getKeyList() {
        return this.keyList;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public ArrayList<CFGPropertyMacro> getMarcoList() {
        return this.marcoList;
    }

    public String getModel() {
        return this.model;
    }

    public String getRatio() {
        return this.ratio;
    }

    public int getScreen_edge_reset() {
        return this.screen_edge_reset;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.title, Integer.valueOf(this.screen_edge_reset), this.keyList, this.jsList, this.marcoList);
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public boolean isForCurrentDevice(String str) {
        boolean zB = n0.b(this.gamepad, h.A);
        return n0.b(str, h.A) ? zB : !zB;
    }

    public boolean isInTop() {
        return this.inTop;
    }

    public boolean isInUse() {
        return this.inUse;
    }

    public boolean isInvalid() {
        return this.keyList.isEmpty() && this.jsList.isEmpty() && this.marcoList.isEmpty();
    }

    public boolean isRecommend() {
        return this.isRecommend;
    }

    public boolean isTest() {
        return this.isTest;
    }

    public void setDefault(boolean z10) {
        this.isDefault = z10;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setGamepad(String str) {
        this.gamepad = str;
    }

    public void setInTop(boolean z10) {
        this.inTop = z10;
    }

    public void setInUse(boolean z10) {
        this.inUse = z10;
    }

    public void setJsList(ArrayList<CFGPropertyJS> arrayList) {
        this.jsList = arrayList;
    }

    public void setKeyList(ArrayList<CFGPropertyKey> arrayList) {
        this.keyList = arrayList;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setMarcoList(ArrayList<CFGPropertyMacro> arrayList) {
        this.marcoList = arrayList;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setRatio(String str) {
        this.ratio = str;
    }

    public void setRecommend(boolean z10) {
        this.isRecommend = z10;
    }

    public void setScreen_edge_reset(int i10) {
        this.screen_edge_reset = i10;
    }

    public void setTest(boolean z10) {
        this.isTest = z10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "CFGEntity{title='" + this.title + "',gamepad='" + this.gamepad + "', keyList=" + this.keyList.size() + ", jsList=" + this.jsList.size() + ", marcoList=" + this.marcoList.size() + ", inUse=" + this.inUse + ", inTop=" + this.inTop + ", isRecommend=" + this.isRecommend + ", isDefault=" + this.isDefault + ", isTest=" + this.isTest + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeString(this.manufacturer);
        parcel.writeString(this.model);
        parcel.writeString(this.gamepad);
        parcel.writeByte(this.inUse ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.inTop ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isTest ? (byte) 1 : (byte) 0);
        parcel.writeString(this.ratio);
        parcel.writeInt(this.screen_edge_reset);
        parcel.writeTypedList(this.keyList);
        parcel.writeTypedList(this.jsList);
        parcel.writeTypedList(this.marcoList);
    }

    public CFGEntity() {
        this.title = "";
        this.desc = "";
        this.isDefault = false;
        this.isRecommend = false;
        this.screen_edge_reset = 0;
        this.keyList = new ArrayList<>();
        this.jsList = new ArrayList<>();
        this.marcoList = new ArrayList<>();
    }
}
